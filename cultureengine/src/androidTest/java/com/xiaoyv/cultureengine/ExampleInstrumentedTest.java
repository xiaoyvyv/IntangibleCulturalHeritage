package com.xiaoyv.cultureengine;

import android.content.Context;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.blankj.utilcode.util.FileIOUtils;
import com.blankj.utilcode.util.FileUtils;
import com.blankj.utilcode.util.GsonUtils;
import com.blankj.utilcode.util.ResourceUtils;
import com.xiaoyv.cultureengine.module.holl.HallBean;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();

        String json = "民间文学";
        File file = new File("C:\\Users\\why\\AndroidStudioProjects\\IntangibleCulturalHeritage\\cultureengine\\src\\main\\assets\\online_hall\\" + json + ".json");

        Document document = Jsoup.parse(ResourceUtils.readAssets2String("test.html"));
        Elements elements = document.select("ui>li>a");

        HallBean hallBean = new HallBean();
        List<HallBean.HallData> cultureData = new ArrayList<>();
        for (Element element : elements) {
            String title = element.select("h5").text();
            String content = element.select("p").text();
            String local = element.select(".red").text();
            String image = element.select("img").attr("src");
            String tip = element.select(".text").text();

            HallBean.HallData banner = new HallBean.HallData();
            banner.setTitle(title);
            banner.setImage(image);
            banner.setContent(content);
            banner.setLocal(local);
            banner.setImageTip(tip);
            cultureData.add(banner);
        }
        hallBean.setHoll(cultureData);
        FileUtils.createOrExistsFile(file);
        FileIOUtils.writeFileFromString(file, GsonUtils.toJson(hallBean));
    }
}
