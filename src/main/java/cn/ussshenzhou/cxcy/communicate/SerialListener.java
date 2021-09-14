package cn.ussshenzhou.cxcy.communicate;

import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;

/**
 * @author USS_Shenzhou
 */
public class SerialListener implements SerialPortEventListener {
    @Override
    public void serialEvent(SerialPortEvent serialPortEvent) {
        switch (serialPortEvent.getEventType()) {
            // 10通讯中断
            case SerialPortEvent.BI:
                break;
            // 7溢位错误
            case SerialPortEvent.OE:
                break;
            // 9帧错误
            case SerialPortEvent.FE:
                break;
            // 8奇偶校验错
            case SerialPortEvent.PE:
                break;
            // 6载波检测
            case SerialPortEvent.CD:
                break;
            // 3清除发送
            case SerialPortEvent.CTS:
                break;
            // 4数据设备准备好
            case SerialPortEvent.DSR:
                break;
            // 5振铃指示
            case SerialPortEvent.RI:
                break;
            // 2输出缓冲区已清空
            case SerialPortEvent.OUTPUT_BUFFER_EMPTY:
                break;
            // 1读到可用数据时激活
            case SerialPortEvent.DATA_AVAILABLE:
                DecodeManager.decode();
                break;
            default:
                break;
        }

    }
}
