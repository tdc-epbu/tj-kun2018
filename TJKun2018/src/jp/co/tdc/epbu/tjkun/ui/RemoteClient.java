package jp.co.tdc.epbu.tjkun.ui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 *
 */
public class RemoteClient extends Frame implements KeyListener, Runnable {
    private static final long serialVersionUID = 1630664954341554884L;

    private static final String EV3_IPADDR = "10.0.1.1";

    public static final int PORT = 7360;

    public static final int CLOSE = 0;
    public static final int START = 71; // 'g'
    public static final int STOP  = 83; // 's'

    Button btnConnect;
    TextField txtIPAddress;
    TextArea messages;

    private Socket socket;
    private DataOutputStream outStream;

    private DataInputStream inStream;

	private static ScheduledExecutorService scheduler;
	private static ScheduledFuture<?> log;

    public RemoteClient(String title, String ip) {
        super(title);
        this.setSize(400, 300);
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.out.println("Ending Warbird Client");
                disconnect();
                System.exit(0);
            }
        });
        buildGUI(ip);
        this.setVisible(true);
        btnConnect.addKeyListener(this);

    }

    public static void main(String args[]) {
        String ip = EV3_IPADDR;
        if (args.length > 0) ip = args[0];
        System.out.println("Starting Client...");
        RemoteClient obj = new RemoteClient("LeJOS EV3 Client Sample", ip);
		scheduler = Executors.newScheduledThreadPool(2);
        log = scheduler.scheduleAtFixedRate(obj, 0, 500, TimeUnit.MILLISECONDS);
    }

    public void buildGUI(String ip) {
        Panel mainPanel = new Panel(new BorderLayout());
        ControlListener cl = new ControlListener();
        btnConnect = new Button("Connect");
        btnConnect.addActionListener(cl);
        txtIPAddress = new TextField(ip, 16);
        messages = new TextArea("status: DISCONNECTED");
        messages.setEditable(false);
        Panel north = new Panel(new FlowLayout(FlowLayout.LEFT));
        north.add(btnConnect);
        north.add(txtIPAddress);
        Panel center = new Panel(new GridLayout(5, 1));
        center.add(new Label("G to start, S to stop"));
        Panel center4 = new Panel(new FlowLayout(FlowLayout.LEFT));
        center4.add(messages);
        center.add(center4);
        mainPanel.add(north, "North");
        mainPanel.add(center, "Center");
        this.add(mainPanel);
    }

    private void sendCommand(int command) {
        messages.setText("status: SENDING command.");
        try {
            outStream.writeInt(command);
            messages.setText("status: Comand SENT");
        } catch(IOException io) {
            messages.setText("status: ERROR Probrems occurred sending data.");
        }
    }

    private class ControlListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            if (command.equals("Connect")) {
                try {
                    socket = new Socket(txtIPAddress.getText(), PORT);
                    outStream = new DataOutputStream(socket.getOutputStream());
                    inStream = new DataInputStream(socket.getInputStream());
                    messages.setText("status: CONNECTED");
                    btnConnect.setLabel("Disconnect");


                } catch (Exception exc) {
                    messages.setText("status: FAILURE Error establishing connection with EV3.");
                    System.out.println("Error" + exc);
                }
            } else if (command.equals("Disconnect")) {
                disconnect();
            }
        }
    }

    public void disconnect() {
        try {
            sendCommand(CLOSE);
            socket.close();
            btnConnect.setLabel("Connect");
            messages.setText("status: DISCONNECTED");
        } catch (Exception exc) {
            messages.setText("status: FAILURE Error closing connection with EV3.");
            System.out.println("Error" + exc);
        }
    }

    public void keyPressed(KeyEvent e) {
        sendCommand(e.getKeyCode());
        System.out.println("Pressed " + e.getKeyCode());
    }

    public void keyReleased(KeyEvent e) {}
    public void keyTyped(KeyEvent arg0) {}

    @Override
    public void run() {


            	if(inStream == null) {
                    System.out.println("xxx");
            		return;
            	}

                try {
                    if (inStream.available() > 0) {
                        //System.out.println(inStream.readFloat());
                        // 送られてきたバイト配列から各値を取り出して表示。

                    	byte[] logByte = new byte[20];

                    	inStream.read(logByte);

                    	ByteBuffer bb = ByteBuffer.wrap(logByte);

                    	System.out.println(bb.getFloat(0) + ":" + bb.getFloat(4) + ":" + bb.getFloat(8) + ":" + bb.getInt(12) + ":" + bb.getInt(16));
                    }
                } catch (IOException e) {
                    // TODO 自動生成された catch ブロック
                    e.printStackTrace();
                }


    }
}