package com.railway.data.railway.service;

import com.railway.data.railway.util.HexUtil;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.util.logging.Logger;


/**
 * @program: subway
 * @description: 发送udp
 * @author: lijiwen
 * @create: 2019-09-20 17:47
 **/
@Service
public class UdpSendService {
    public static Logger logger = Logger.getLogger(UdpSendService.class.getName());

    public void Process(DatagramPacket packet) throws UnsupportedEncodingException {
        logger.info("get UDP message is");
        // 接收到的UDP信息，然后解码
        byte[] buffer = packet.getData();
        String srt2 = HexUtil.bytes2HexString(buffer);
        logger.info("Process srt2 UTF-8" + srt2);
    }
}
