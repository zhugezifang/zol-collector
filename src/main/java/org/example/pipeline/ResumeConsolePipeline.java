package org.example.pipeline;

import com.alibaba.fastjson.JSONObject;
import org.example.domain.Resume;
import org.example.domain.ZolResult;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Optional;

public class ResumeConsolePipeline implements Pipeline {

    @Override
    public void process(ResultItems resultItems, Task task) {
        FileWriter fw = null;
        try {
            //如果文件存在，则追加内容；如果文件不存在，则创建文件
            String filePath = System.getProperty("user.dir") + "/src/main/resources/resume-new.txt";
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
            Resume zolResult = (Resume) entry.getValue();
            System.out.println(JSONObject.toJSONString(zolResult));
            String str = zolResult.getId() + "\t" + zolResult.getTitle() + "\t" + zolResult.getImgUrl()+"\t" + zolResult.getContentImgUrl()+ "\t" + zolResult.getDownloadUrl();
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