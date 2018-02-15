import io.socket.client.Ack;
import io.socket.client.IO;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;
import org.json.JSONArray;
import org.json.JSONException;

import java.net.URISyntaxException;
import java.util.ArrayList;

public class India {
    private static Socket socket;

    static {
        try {
            socket = IO.socket("http://ferma.facecoin.ru:8001");
            System.out.println("Fine!");
        } catch (URISyntaxException e) {
            System.out.println("Error Connecting to IP!" + e.getMessage());
        }
    }


    public static void main(String[] args) {

        socket.connect();
        socket.on("connect", new Emitter.Listener() {
            @Override
            public void call(Object... objects) {

            }
        });


//        socket.emit("farmList", new Ack() {
//            @Override
//            public void call(Object... objects) {
//
//                JSONArray list = (JSONArray) objects[1];
//                for (int i = 0; i < list.length(); i++) {
//                    try {
//                        if(list.getString(i).contains("gzd24")){
//                            System.out.println(list.getString(i));
//                        }
//                    } catch (JSONException e) {
//                        e.printStackTrace();
//                    }
//                }
//
//            }
//        });

        socket.emit("minersStat", "gzd24x1@profit.pool.bitcoin.com:3333", new Ack() {
            @Override
            public void call(Object... objects) {
                System.out.println(objects);
            }
        });

        System.out.println("ok");
//        socket.close();
    }
}
