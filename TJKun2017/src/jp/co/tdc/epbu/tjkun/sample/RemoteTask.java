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
import java.nio.ByteBuffer;

import jp.co.tdc.epbu.tjkun.device.EV3;

/**
 * PC との通信制御タスク。
 */
public class RemoteTask implements Runnable {
	public static final int REMOTE_COMMAND_START = 71; // 'g'
	public static final int REMOTE_COMMAND_STOP = 83; // 's'

	private static final int SOCKET_PORT = 7360; // PCと接続するポート

	private ServerSocket server;
	private Socket client;
	private InputStream inputStream;
	private DataInputStream dataInputStream;
	private int remoteCommand;

	private OutputStream outputStream;
	private DataOutputStream dataOutputStream;

	private static RemoteTask remoteTask = null;

	public static RemoteTask getInstance() {

		if (remoteTask == null) {
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

				EV3 ev3 = EV3.getInstance();

				// 送りたいデータのバイト配列を作成する。
				// 配列レイアウト：輝度値(4),障害物との距離(4),角速度(4),左モーター速度(4),右モーター速度(4),

				byte[] LogByte = ByteBuffer.allocate(20).putFloat(0, ev3.getBrightness()).putFloat(4, ev3.getSonarDistance()).putFloat(8, ev3.getGyroValue()).
						putInt(12, ev3.getLMotorCount()).putInt(16, ev3.getRMotorCount()).array();

				dataOutputStream.write(LogByte);

				// 作成したたバイト配列を送る。 dataOutputStream.write(b);
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
	 *
	 * @param command
	 *            コマンド
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
			try {
				server.close();
			} catch (IOException ex) {
			}
		}
	}
}
