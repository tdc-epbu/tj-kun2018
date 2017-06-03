/*
 *  RemoteTask.java (for leJOS EV3)
 *  Created on: 2016/02/11
 *  Copyright (c) 2016 Embedded Technology Software Design Robot Contest
 */
package jp.co.tdc.epbu.tjkun.sample;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * PC との通信制御タスク。
 */
public class RemoteTask implements Runnable {
    public static final int   REMOTE_COMMAND_START = 71;   // 'g'
    public static final int   REMOTE_COMMAND_STOP  = 83;   // 's'

    private static final int   SOCKET_PORT          = 7360; // PCと接続するポート

    private ServerSocket    server;
    private Socket          client;
    private InputStream     inputStream;
    private DataInputStream dataInputStream;
    private int             remoteCommand;

    private OutputStream    outputStream;
    private DataOutputStream dataOutputStream;




    private static RemoteTask remoteTask = null;

    public static RemoteTask getInstance() {

    	if(remoteTask == null) {
    		remoteTask = new RemoteTask();
    	}

    	return remoteTask;
    }


    /**
     * コンストラクタ。
     */
    private RemoteTask() {
        server = null;
        client = null;
        inputStream = null;
        dataInputStream = null;
        remoteCommand = 0;
    }

    /**
     * PC との通信制御。
     */
    @Override
    public void run() {
        try {
            if (server == null) { // 未接続
                server = new ServerSocket(SOCKET_PORT);
                client = server.accept();
                inputStream = client.getInputStream();
                dataInputStream = new DataInputStream(inputStream);

                outputStream = client.getOutputStream();
                dataOutputStream = new DataOutputStream(outputStream);

            } else {
                if (dataInputStream.available() > 0) {
                    remoteCommand = dataInputStream.readInt();
                }

                dataOutputStream.writeInt(999);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
            server = null;
            dataInputStream = null;
            dataOutputStream = null;
        }
    }

    /**
     * リモートコマンドのチェック。
     * @param command コマンド
     */
    public final boolean checkRemoteCommand(int command) {
        if (remoteCommand > 0) {
            if (remoteCommand == command) {
                return true;
            }
        }
        return false;
    }

    /**
     * 終了処理。
     */
    public void close() {
        if (server != null) {
            try { server.close(); } catch (IOException ex) {}
        }
    }
}

