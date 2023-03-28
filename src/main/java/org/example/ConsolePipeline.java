package org.example;

import com.alibaba.fastjson.JSONObject;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.Map;
import java.util.Optional;

public class ConsolePipeline implements Pipeline {

    @Override
    public void process(ResultItems resultItems, Task task) {
        FileWriter fw = null;
        try {
            //如果文件存在，则追加内容；如果文件不存在，则创建文件
            String filePath = System.getProperty("user.dir") + "/src/main/resources/zol.txt";
            System.out.println(filePath);
            File f = new File(filePath);
            if (!f.exists()) {
                f.createNewFile();
            }
            fw = new FileWriter(f, true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        PrintWriter pw = new PrintWriter(fw);
        for (Map.Entry<String, Object> entry : resultItems.getAll().entrySet()) {
            ZolResult zolResult = (ZolResult) entry.getValue();
            System.out.println(JSONObject.toJSONString(zolResult));
            String str = zolResult.getProductId() + "\t" + zolResult.getListUrl() + "\t" + zolResult.getParamUrl() + "\t" + zolResult.getTitle() + "\t"
                    + Optional.ofNullable(zolResult.getPrice()).orElse("") + "\t"
                    + Optional.ofNullable(zolResult.getRam()).orElse("") + "\t"
                    + Optional.ofNullable(zolResult.getRom()).orElse("") + "\t"
                    + Optional.ofNullable(zolResult.getBrand()).orElse("") + "\t"
                    + Optional.ofNullable(zolResult.getSeries()).orElse("") + "\t"
                    + Optional.ofNullable(zolResult.getOnlineDate()).orElse("");
            pw.println(str);
        }
        pw.flush();
        try {
            fw.flush();
            pw.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}