package cn.ussshenzhou.cxcy.communicate;

import cn.ussshenzhou.cxcy.utils.LogManager;
import gnu.io.*;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.PortUnreachableException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.TooManyListenersException;

/**
 * @author USS_Shenzhou
 */
public class CommManager {
    private static ArrayList<String> portNames = new ArrayList<>();
    private static SerialPort serialPort;
    private static final int TIME_OUT = 2000;
    private static int baudRate = 9600;

    public static void init() {
        //seekPorts();
    }

    public static void refreshPorts() {
        portNames.clear();
        if (serialPort != null) {
            serialPort.close();
        }
        seekPorts();
    }

    public static void seekPorts() {
        Enumeration<CommPortIdentifier> ports = CommPortIdentifier.getPortIdentifiers();
        while (ports.hasMoreElements()) {
            CommPortIdentifier c = ports.nextElement();
            if (c.getPortType() == CommPortIdentifier.PORT_SERIAL && !c.isCurrentlyOwned()) {
                portNames.add(c.getName());
            }
        }
        LogManager.LOGGER.info("available ports:" + portNames);
    }

    public static ArrayList<String> getPortNames() {
        return portNames;
    }

    public static void setPort(String name) {
        try {
            CommPortIdentifier commPortIdentifier = CommPortIdentifier.getPortIdentifier(name);
            CommPort commPort = commPortIdentifier.open(name, TIME_OUT);

            if (commPort instanceof SerialPort) {
                if (serialPort != null) {
                    serialPort.close();
                    LogManager.LOGGER.info("port " + serialPort.getName() + " closed");
                }
                serialPort = (SerialPort) commPort;
                serialPort.setSerialPortParams(baudRate, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);
                serialPort.addEventListener(new SerialListener());
                serialPort.notifyOnDataAvailable(true);

                LogManager.LOGGER.info("port " + serialPort.getName() + " opened with baud rate " + baudRate);
            } else {
                commPort.close();
                throw new PortUnreachableException("Port" + name + "is not a serial port");
            }
        } catch (NoSuchPortException | PortUnreachableException | PortInUseException | UnsupportedCommOperationException | TooManyListenersException e) {
            e.printStackTrace();
            LogManager.LOGGER.severe(e.getMessage());
            throw new RuntimeException();
        }

    }

    @Deprecated
    public static byte[] readPort() {
        byte[] bytes = null;
        try {
            InputStream inputStream = serialPort.getInputStream();
            int l = inputStream.available();
            if (l != 0) {
                bytes = new byte[l];
                inputStream.read(bytes);
            }
            LogManager.LOGGER.info(l + "bytes read");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bytes;
    }

    public static ArrayList<Character> readPortAsChars() {
        ArrayList<Character> chars = new ArrayList<>();
        try {
            InputStream inputStream = serialPort.getInputStream();
            int l = inputStream.available();
            if (l != 0) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                do {
                    int i = inputStreamReader.read();
                    chars.add((char) i);
                } while (chars.size() != l);
            }
            LogManager.LOGGER.info(l + "bytes read");
        } catch (IOException e) {
            e.printStackTrace();
            LogManager.LOGGER.warning(e.getMessage());
        }
        return chars;
    }

    public static void setBaudRate(int baudRate) {
        CommManager.baudRate = baudRate;
        if (serialPort != null) {
            try {
                serialPort.setSerialPortParams(baudRate, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);
                LogManager.LOGGER.info("set baud rate to " + baudRate);
            } catch (UnsupportedCommOperationException e) {
                LogManager.LOGGER.warning(e.getMessage());
                e.printStackTrace();
            }
        }
    }
}
