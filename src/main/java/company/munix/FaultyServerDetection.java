package company.munix;

import java.util.HashMap;
import java.util.List;

public class FaultyServerDetection {

    public static void main(String[] args) {


    }

    public static int countFaults(int n, List<String> logs) {
        HashMap<String, String> serverStatus = new HashMap<>();
        int replacements = 0;
        String errorLimit = "";
        for (int i = 0; i < n; i++) {
            errorLimit += "0";
        }

        for (String log : logs) {
            String[] parts = log.split(" ");
            String serverId = parts[0];
            String status = parts[1];

            if (!serverStatus.containsKey(serverId)) {

                serverStatus.put(serverId, status.equals("success") ? "1" : "0");//adding the server for the 1st time
            } else {
                switch (status) {
                    case "0": {
                        serverStatus.put(serverId, serverStatus.get(serverId) + "0");//added a

                    }
                    case "1": {
                        serverStatus.put(serverId, "");//refreshing the error status
                    }
                }


                if (serverStatus.get(serverId).equals(errorLimit)) {//0 means one fault 000 means 3 cxonsecutvre fault
                    replacements++;
                    serverStatus.put(serverId, "");//refreshing the error status
                }
            }

        }

        return replacements;
    }


}
