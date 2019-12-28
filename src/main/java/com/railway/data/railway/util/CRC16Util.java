package com.railway.data.railway.util;



public class CRC16Util {

    public static int get_crc16(int[] bufData, int buflen) {
        int ret = 0;
        int CRC = 0x0000ffff;
        int POLYNOMIAL = 0x0000a001;
        int i, j;


        if (buflen == 0) {
            return ret;
        }
        for (i = 0; i < buflen; i++) {
            CRC ^= ((int) bufData[i] & 0x000000ff);
            for (j = 0; j < 8; j++) {
                if ((CRC & 0x00000001) != 0) {
                    CRC >>= 1;
                    CRC ^= POLYNOMIAL;
                } else {
                    CRC >>= 1;
                }
            }
        }

        return CRC;
    }

    public static String creatCrc16_s(String data) {
        int[] datas = DataUtil.creatDateInt(data);
        int crcResult = get_crc16(datas, datas.length);
        StringBuilder sb = new StringBuilder();
        String low = Integer.toHexString(crcResult & 0x000000ff);
        if (low.length() < 2) {
            sb.append("0").append(low);
        } else {
            sb.append(low);
        }

        String hight = Integer.toHexString(crcResult >> 8);
        if (hight.length() < 2) {
            sb.append("0").append(hight);
        } else {
            sb.append(hight);
        }
        return sb.toString().toUpperCase();
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        //EB 6A 2E 00 21 05 03 01 25 FF FF 72 0E 01 00 00 00 00 00 00 00 00 01 71 33 01 00 0D 01 33 19 01 00 37 01 00 07 01 35 19 01 41 67 F7 0D 0A
        String str = "EB 6A 2 00 21 05 03 01 25 FF FF 72 0E 01 00 00 00 00 00 00 00 00 01 71 33 01 00 0D 01 33 19 01 00 37 01 00 07 01 35 19 01 41";
        int[] mm = DataUtil.creatDateInt(str.replaceAll(" ", ""));
        int crc16 = get_crc16(mm, mm.length);
        System.out.println(Integer.toHexString(crc16 & 0x000000ff));
        System.out.println(Integer.toHexString(crc16 >> 8));
        System.out.println(creatCrc16_s(str.replaceAll(" ", "")));
    }
}
