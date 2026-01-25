import java.nio.ByteBuffer;

public class SignalRParser {
    public static void main(String[] args) {
        byte[] data = hexToBytes("1FEFBFBD0800000000000400EFBFBD07601C49EFBFBD25262F6DEFBFBD7B7F4AEFBFBD4AEFBFBDEFBFBD74EFBFBD08EFBFBD601324D8904010EFBFBDEFBFBDEFBFBDEFBFBDEFBFBDEFBFBD1D69472329EFBFBD2AEFBFBDEFBFBD6556655D661640EFBFBDED9DBCEFBFBDEFBFBD7BEFBFBDEFBFBDEFBFBD7BEFBFBDEFBFBDEFBFBD3BEFBFBD4E27EFBFBDEFBFBDEFBFBD3F5C6664016CEFBFBDEFBFBD4AEFBFBDC99E21EFBFBDEFBFBDEFBFBD1F3F7E7C1F3F22EFBFBD1F0000000000000000");

        parseSignalRMessage(data);
    }

    public static void parseSignalRMessage(byte[] data) {
        System.out.println("=== SignalR Message Analysis ===");
        System.out.println("Total length: " + data.length + " bytes");

        // Типы сообщений SignalR
        String[] messageTypes = {
                "0: Keep-Alive", "1: Invocation", "2: StreamItem",
                "3: Completion", "4: StreamInvocation", "5: CancelInvocation",
                "6: Ping", "7: Close"
        };

        // Первый байт - тип сообщения
        int messageType = data[0] & 0xFF;
        System.out.println("\n1. Message Type: " + messageType);
        if (messageType < messageTypes.length) {
            System.out.println("   " + messageTypes[messageType]);
        }

        // Ищем длину (скорее всего little-endian int на позиции 1-4)
        if (data.length >= 5) {
            int length = ByteBuffer.wrap(data, 1, 4).order(java.nio.ByteOrder.LITTLE_ENDIAN).getInt();
            System.out.println("\n2. Possible length field: " + length + " (little-endian)");
        }

        // Ищем текстовые данные
        System.out.println("\n3. Text segments found:");
        findTextInData(data);

        // Hex дамп первых 64 байт
        System.out.println("\n4. First 64 bytes (hex):");
        hexDump(data, 64);

        // Пробуем разные смещения для чтения длины
        System.out.println("\n5. Testing different offsets for length:");
        for (int offset = 1; offset < Math.min(20, data.length - 4); offset++) {
            try {
                int len = ByteBuffer.wrap(data, offset, 4)
                        .order(java.nio.ByteOrder.LITTLE_ENDIAN)
                        .getInt();
                if (len > 0 && len < data.length * 2) {
                    System.out.printf("   Offset %d: length = %d (0x%08X)\n",
                            offset, len, len);
                }
            } catch (Exception e) {
                // ignore
            }
        }
    }

    private static void findTextInData(byte[] data) {
        StringBuilder currentText = new StringBuilder();
        boolean inText = false;

        for (int i = 0; i < data.length; i++) {
            // Printable ASCII + кириллица в UTF-8
            if ((data[i] >= 32 && data[i] <= 126) ||
                    (i + 1 < data.length && data[i] < 0 && data[i+1] < 0)) { // possible UTF-8
                if (!inText) {
                    inText = true;
                }
                currentText.append(String.format("%c", data[i] & 0xFF));
            } else {
                if (inText && currentText.length() > 3) {
                    System.out.println("   At position " + (i - currentText.length()) +
                            ": \"" + currentText + "\"");
                }
                inText = false;
                currentText.setLength(0);
            }
        }

        // Последний кусок
        if (inText && currentText.length() > 3) {
            System.out.println("   At position " + (data.length - currentText.length()) +
                    ": \"" + currentText + "\"");
        }
    }

    private static void hexDump(byte[] data, int maxLength) {
        int length = Math.min(data.length, maxLength);
        for (int i = 0; i < length; i++) {
            System.out.printf("%02X ", data[i]);
            if ((i + 1) % 16 == 0) {
                System.out.print("  ");
                for (int j = i - 15; j <= i; j++) {
                    char c = (data[j] >= 32 && data[j] <= 126) ? (char) data[j] : '.';
                    System.out.print(c);
                }
                System.out.println();
            }
        }
        System.out.println();
    }

    private static byte[] hexToBytes(String hex) {
        hex = hex.replaceAll("\\s+", "");
        byte[] bytes = new byte[hex.length() / 2];
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = (byte) Integer.parseInt(hex.substring(i * 2, i * 2 + 2), 16);
        }
        return bytes;
    }
}