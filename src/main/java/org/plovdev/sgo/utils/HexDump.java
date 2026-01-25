package org.plovdev.sgo.utils;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

public class HexDump {

    /**
     * Делает hex дамп байтового массива
     * @param data байтовый массив
     * @return строка с hex дампом
     */
    public static String hexDump(byte[] data) {
        return hexDump(data, 0, data.length);
    }

    /**
     * Делает hex дамп части байтового массива
     * @param data байтовый массив
     * @param offset начальная позиция
     * @param length количество байт
     * @return строка с hex дампом
     */
    public static String hexDump(byte[] data, int offset, int length) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < length; i += 16) {
            // Адрес
            sb.append(String.format("%08X: ", offset + i));

            // Hex байты
            for (int j = 0; j < 16; j++) {
                if (i + j < length) {
                    sb.append(String.format("%02X ", data[offset + i + j] & 0xFF));
                } else {
                    sb.append("   ");
                }

                if (j == 7) sb.append(" "); // Пробел посередине
            }

            sb.append(" ");

            // ASCII символы
            for (int j = 0; j < 16; j++) {
                if (i + j < length) {
                    byte b = data[offset + i + j];
                    if (b >= 32 && b <= 126) { // Printable ASCII
                        sb.append((char) b);
                    } else {
                        sb.append(".");
                    }
                }
            }

            sb.append("\n");
        }

        return sb.toString();
    }

    /**
     * Делает hex дамп с дополнительной информацией
     */
    public static String detailedHexDump(byte[] data) {
        StringBuilder sb = new StringBuilder();

        sb.append("=== Hex Dump (").append(data.length).append(" bytes) ===\n");
        sb.append(hexDump(data));

        // Дополнительный анализ
        sb.append("\n=== Analysis ===\n");
        sb.append("First byte: 0x").append(String.format("%02X", data[0]))
                .append(" = ").append(data[0] & 0xFF).append("\n");

        if (data.length >= 4) {
            // Little-endian
            int leInt = ByteBuffer.wrap(data, 0, 4)
                    .order(ByteOrder.LITTLE_ENDIAN).getInt();
            sb.append("First 4 bytes (LE): ").append(leInt)
                    .append(" (0x").append(Integer.toHexString(leInt)).append(")\n");

            // Big-endian
            int beInt = ByteBuffer.wrap(data, 0, 4)
                    .order(ByteOrder.BIG_ENDIAN).getInt();
            sb.append("First 4 bytes (BE): ").append(beInt)
                    .append(" (0x").append(Integer.toHexString(beInt)).append(")\n");
        }

        // Поиск текста
        sb.append("\nText segments:\n");
        findTextSegments(data, sb);

        return sb.toString();
    }

    private static void findTextSegments(byte[] data, StringBuilder sb) {
        StringBuilder currentText = new StringBuilder();
        int textStart = -1;
        boolean inText = false;

        for (int i = 0; i < data.length; i++) {
            byte b = data[i];

            if ((b >= 32 && b <= 126) || // ASCII printable
                    (b < 0 && i + 1 < data.length && data[i+1] < 0)) { // UTF-8

                if (!inText) {
                    inText = true;
                    textStart = i;
                    currentText.setLength(0);
                }
                currentText.append((char) (b & 0xFF));
            } else {
                if (inText && currentText.length() >= 3) {
                    sb.append(String.format("  [%04X] \"%s\"\n",
                            textStart, currentText));
                }
                inText = false;
            }
        }

        // Последний сегмент
        if (inText && currentText.length() >= 3) {
            sb.append(String.format("  [%04X] \"%s\"\n",
                    textStart, currentText));
        }
    }

    /**
     * Конвертирует hex строку в байтовый массив
     */
    public static byte[] hexToBytes(String hex) {
        hex = hex.replaceAll("[^0-9A-Fa-f]", "");
        if (hex.length() % 2 != 0) {
            throw new IllegalArgumentException("Hex string must have even length");
        }

        byte[] bytes = new byte[hex.length() / 2];
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = (byte) Integer.parseInt(hex.substring(i * 2, i * 2 + 2), 16);
        }
        return bytes;
    }

    /**
     * Конвертирует байтовый массив в hex строку
     */
    public static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02X ", b & 0xFF));
        }
        return sb.toString().trim();
    }

    /**
     * Простой hex дамп для консоли
     */
    public static void printHexDump(byte[] data) {
        System.out.println(detailedHexDump(data));
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString("\u001F\u0004�\u0007`\u001CI�%&/m�{\u007FJ�J��t�`\u0013$ؐ@\u0010������\u001DiG#)�*��eVe]f\u0016@�흼��{���{���;�N'���?\\fd\u0001l��J�ɞ!���\u001F?~|\u001F?\"�\u001F".getBytes()));
    }
}