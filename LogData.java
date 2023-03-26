import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Map.Entry;


public class LogData  {
    public List<ModelLog> datalogs = new ArrayList<>();
    public Map<String,Integer> ipaddress = new HashMap<>();
    public Map<String,Integer> brower = new HashMap<>();
    public String importLogfile(String filename){
        try{
            FileInputStream fileInputStream = new FileInputStream(filename);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
            String str_line;
            while((str_line = bufferedReader.readLine())!=null){
                ModelLog log = setterLog(str_line);
                datalogs.add(log);
            }
            fileInputStream.close();
            mapIpAddress();
            mapBrower();
        }
        catch (Exception e){
            return "Error.importLog";
        }
        return "Import_Setter_Success ";
    }

    public ModelLog setterLog(String str_line){
        String[] strings = str_line.split("\"");
        String[] stringsOfZero = strings[0].split("- -");
        //CHECK SPLIT
//        for (String str : strings){
//            System.out.println(str);
//        }
        ModelLog log = new ModelLog();
        log.setIpAddress(stringsOfZero[0]);
        log.setTime(stringsOfZero[1]);
        log.setDeviceType(strings[1]);
        log.setNewAttr(strings[2].substring(1));
        log.setReferURL(strings[3]);
        // because 172.71.222.239 - - [08/Mar/2023:05:12:04 +0700] "GET /wp-content/uploads/2019/06/autohome-1-1024x683.jpg HTTP/1.1" 200 80234 "-" "" มัน split ได้ 5 ตัว เเต่จริงๆต้อง 6
        if (strings.length == 5){
            log.setBrower("-");
        }
        else{
            log.setBrower(strings[5]);
        }
//        System.out.println(log);
        return log;
    }

    private void mapIpAddress(){
        for (ModelLog log:datalogs) {
            if (!ipaddress.containsKey(log.getIpAddress())) {
                ipaddress.put(log.getIpAddress(), 1);
            } else {
                ipaddress.replace(log.getIpAddress(), ipaddress.get(log.getIpAddress()), ipaddress.get(log.getIpAddress()) + 1);
            }
        }

    }
    private void mapBrower(){
        for (ModelLog log:datalogs){
            if(!brower.containsKey(log.getBrower())){
                brower.put(log.getBrower(),1);
            }
            else{
                brower.replace(log.getBrower(),brower.get(log.getBrower()),brower.get(log.getBrower())+1);
            }
        }
    }
    public Integer getSizeOfBrower(){
        return brower.size();
    }
    public Set<String> getBrower(){
        return brower.keySet();
    }
    public Set<String> getIpAddress(){
        return ipaddress.keySet();
    }
    public Integer getSizeDataLogs(){
        return datalogs.size();
    }
    public Integer getSizeOfIpAddress(){
        return ipaddress.keySet().size();
    }
    public List<List<String>> topBrower(){
        return coventToTop(brower);
    }
    public List<List<String>> topIpAddress(){
        return coventToTop(ipaddress);
    }
    private List<List<String>> coventToTop(Map<String,Integer> map){
        List<List<String>> lists= new ArrayList<>();
        List<Entry<String, Integer>> sort = sortByValue(map);
        for(int i=0;i<10;i++){
            List<String> list= new ArrayList<>();
            list.add(sort.get(i).getKey());
            list.add(String.valueOf(sort.get(i).getValue()));
            lists.add(list);
        }
        return lists;
    }
    private List<Entry<String, Integer>> sortByValue(Map<String,Integer> map){

        Set<Entry<String, Integer>> set = map.entrySet();
        List<Entry<String, Integer>> list = new ArrayList<>(
                set);
        Collections.sort(list, (o1, o2) -> o2.getValue().compareTo(o1.getValue()));

        return list.subList(0,10);
    }





}
