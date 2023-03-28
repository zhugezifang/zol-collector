package org.example;

import static org.junit.Assert.assertTrue;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }

    @Test
    public void testBrand() {
        String str = "<div id=\"J_BrandAll\" data-multi=\"0\" class=\"brand-list\"><a href=\"/cell_phone_index/subcate57_613_list_1.html\" data-link=\"613\" data-letter=\"H\">华为</a><a href=\"/cell_phone_index/subcate57_1795_list_1.html\" data-link=\"1795\" data-letter=\"V\">vivo</a><a href=\"/cell_phone_index/subcate57_1673_list_1.html\" data-link=\"1673\" data-letter=\"O\">OPPO</a><a href=\"/cell_phone_index/subcate57_544_list_1.html\" data-link=\"544\" data-letter=\"P\">苹果</a><a href=\"/cell_phone_index/subcate57_98_list_1.html\" data-link=\"98\" data-letter=\"S\">三星</a><a href=\"/cell_phone_index/subcate57_50840_list_1.html\" data-link=\"50840\" data-letter=\"R\">荣耀</a><a href=\"/cell_phone_index/subcate57_55075_list_1.html\" data-link=\"55075\" data-letter=\"I\">iQOO</a><a href=\"/cell_phone_index/subcate57_34645_list_1.html\" data-link=\"34645\" data-letter=\"X\">小米</a><a href=\"/cell_phone_index/subcate57_35579_list_1.html\" data-link=\"35579\" data-letter=\"Y\">一加</a><a href=\"/cell_phone_index/subcate57_1434_list_1.html\" data-link=\"1434\" data-letter=\"M\">魅族</a><a href=\"/cell_phone_index/subcate57_55535_list_1.html\" data-link=\"55535\" data-letter=\"Z\">真我</a><a href=\"/cell_phone_index/subcate57_35005_list_1.html\" data-link=\"35005\" data-letter=\"N\">努比亚</a><a href=\"/cell_phone_index/subcate57_55731_list_1.html\" data-link=\"55731\" data-letter=\"H\">红米</a><a href=\"/cell_phone_index/subcate57_295_list_1.html\" data-link=\"295\" data-letter=\"M\">Moto</a><a href=\"/cell_phone_index/subcate57_642_list_1.html\" data-link=\"642\" data-letter=\"Z\">中兴</a><a class=\"active\" href=\"/cell_phone_index/subcate57_57933_list_1.html\" data-link=\"57933\" data-letter=\"H\">Hi nova</a><a href=\"/cell_phone_index/subcate57_1763_list_1.html\" data-link=\"1763\" data-letter=\"L\">联想</a><a href=\"/cell_phone_index/subcate57_1069_list_1.html\" data-link=\"1069\" data-letter=\"S\">索尼移动</a><a href=\"/cell_phone_index/subcate57_53765_list_1.html\" data-link=\"53765\" data-letter=\"H\">黑鲨</a><a href=\"/cell_phone_index/subcate57_297_list_1.html\" data-link=\"297\" data-letter=\"N\">诺基亚</a><a href=\"/cell_phone_index/subcate57_1922_list_1.html\" data-link=\"1922\" data-letter=\"G\">谷歌</a><a href=\"/cell_phone_index/subcate57_41373_list_1.html\" data-link=\"41373\" data-letter=\"R\">ROG</a><a href=\"/cell_phone_index/subcate57_41412_list_1.html\" data-link=\"41412\" data-letter=\"V\">VERTU</a><a href=\"/cell_phone_index/subcate57_33992_list_1.html\" data-link=\"33992\" data-letter=\"L\">乐视</a><a href=\"/cell_phone_index/subcate57_57729_list_1.html\" data-link=\"57729\" data-letter=\"M\">麦芒</a><a href=\"/cell_phone_index/subcate57_57921_list_1.html\" data-link=\"57921\" data-letter=\"D\">鼎桥通信</a><a href=\"/cell_phone_index/subcate57_57398_list_1.html\" data-link=\"57398\" data-letter=\"U\">U-MAGIC</a><a href=\"/cell_phone_index/subcate57_35320_list_1.html\" data-link=\"35320\" data-letter=\"X\">小辣椒</a><a href=\"/cell_phone_index/subcate57_143_list_1.html\" data-link=\"143\" data-letter=\"L\">LG</a><a href=\"/cell_phone_index/subcate57_57961_list_1.html\" data-link=\"57961\" data-letter=\"M\">魅蓝</a><a href=\"/cell_phone_index/subcate57_57658_list_1.html\" data-link=\"57658\" data-letter=\"N\">NZONE</a><a href=\"/cell_phone_index/subcate57_1606_list_1.html\" data-link=\"1606\" data-letter=\"K\">酷派</a><a href=\"/cell_phone_index/subcate57_58554_list_1.html\" data-link=\"58554\" data-letter=\"W\">WIKO</a><a href=\"/cell_phone_index/subcate57_1632_list_1.html\" data-link=\"1632\" data-letter=\"J\">金立</a><a href=\"/cell_phone_index/subcate57_57939_list_1.html\" data-link=\"57939\" data-letter=\"N\">Nothing</a><a href=\"/cell_phone_index/subcate57_227_list_1.html\" data-link=\"227\" data-letter=\"H\">华硕</a><a href=\"/cell_phone_index/subcate57_34660_list_1.html\" data-link=\"34660\" data-letter=\"A\">AGM</a><a href=\"/cell_phone_index/subcate57_56290_list_1.html\" data-link=\"56290\" data-letter=\" \">遨游</a><a href=\"/cell_phone_index/subcate57_19_list_1.html\" data-link=\"19\" data-letter=\"H\">海信</a><a href=\"/cell_phone_index/subcate57_364_list_1.html\" data-link=\"364\" data-letter=\"W\">微软</a><a href=\"/cell_phone_index/subcate57_12772_list_1.html\" data-link=\"12772\" data-letter=\"H\">黑莓</a><a href=\"/cell_phone_index/subcate57_55893_list_1.html\" data-link=\"55893\" data-letter=\"D\">多亲</a><a href=\"/cell_phone_index/subcate57_56901_list_1.html\" data-link=\"56901\" data-letter=\"U\">Unihertz</a><a href=\"/cell_phone_index/subcate57_35416_list_1.html\" data-link=\"35416\" data-letter=\"Z\">中国电信</a><a href=\"/cell_phone_index/subcate57_159_list_1.html\" data-link=\"159\" data-letter=\"F\">飞利浦</a><a href=\"/cell_phone_index/subcate57_750_list_1.html\" data-link=\"750\" data-letter=\"G\">格力</a><a href=\"/cell_phone_index/subcate57_55542_list_1.html\" data-link=\"55542\" data-letter=\"Z\">征服</a><a href=\"/cell_phone_index/subcate57_55532_list_1.html\" data-link=\"55532\" data-letter=\"R\">柔宇</a><a href=\"/cell_phone_index/subcate57_33080_list_1.html\" data-link=\"33080\" data-letter=\"H\">HTC</a><a href=\"/cell_phone_index/subcate57_49202_list_1.html\" data-link=\"49202\" data-letter=\"8\">8848</a><a href=\"/cell_phone_index/subcate57_300_list_1.html\" data-link=\"300\" data-letter=\"X\">夏普</a><a href=\"/cell_phone_index/subcate57_221_list_1.html\" data-link=\"221\" data-letter=\"H\">海尔</a><a href=\"/cell_phone_index/subcate57_52789_list_1.html\" data-link=\"52789\" data-letter=\"L\">雷鸟</a><a href=\"/cell_phone_index/subcate57_32729_list_1.html\" data-link=\"32729\" data-letter=\"T\">天语</a><a href=\"/cell_phone_index/subcate57_1081_list_1.html\" data-link=\"1081\" data-letter=\"N\">纽曼</a><a href=\"/cell_phone_index/subcate57_53520_list_1.html\" data-link=\"53520\" data-letter=\"K\">克里特</a><a href=\"/cell_phone_index/subcate57_54920_list_1.html\" data-link=\"54920\" data-letter=\"C\">传音</a><a href=\"/cell_phone_index/subcate57_34023_list_1.html\" data-link=\"34023\" data-letter=\"K\">酷比</a><a href=\"/cell_phone_index/subcate57_33855_list_1.html\" data-link=\"33855\" data-letter=\"D\">朵唯</a><a href=\"/cell_phone_index/subcate57_53979_list_1.html\" data-link=\"53979\" data-letter=\"C\">创星</a><a href=\"/cell_phone_index/subcate57_35179_list_1.html\" data-link=\"35179\" data-letter=\"M\">美图</a><a href=\"/cell_phone_index/subcate57_32570_list_1.html\" data-link=\"32570\" data-letter=\"S\">索爱</a><a href=\"/cell_phone_index/subcate57_53005_list_1.html\" data-link=\"53005\" data-letter=\"Z\">詹姆士</a><a href=\"/cell_phone_index/subcate57_35849_list_1.html\" data-link=\"35849\" data-letter=\"C\">锤子科技</a><a href=\"/cell_phone_index/subcate57_57944_list_1.html\" data-link=\"57944\" data-letter=\"3\">360OS奇少年</a><a href=\"/cell_phone_index/subcate57_41933_list_1.html\" data-link=\"41933\" data-letter=\"B\">百合</a><a href=\"/cell_phone_index/subcate57_171_list_1.html\" data-link=\"171\" data-letter=\"T\">TCL</a><a href=\"/cell_phone_index/subcate57_1589_list_1.html\" data-link=\"1589\" data-letter=\"C\">长虹</a><a href=\"/cell_phone_index/subcate57_35228_list_1.html\" data-link=\"35228\" data-letter=\"2\">21克</a><a href=\"/cell_phone_index/subcate57_36792_list_1.html\" data-link=\"36792\" data-letter=\"S\">索野</a><a href=\"/cell_phone_index/subcate57_53640_list_1.html\" data-link=\"53640\" data-letter=\"I\">ioutdoor</a><a href=\"/cell_phone_index/subcate57_35333_list_1.html\" data-link=\"35333\" data-letter=\"O\">欧奇</a><a href=\"/cell_phone_index/subcate57_52848_list_1.html\" data-link=\"52848\" data-letter=\"S\">守护宝</a><a href=\"/cell_phone_index/subcate57_599_list_1.html\" data-link=\"599\" data-letter=\"K\">康佳</a><a href=\"/cell_phone_index/subcate57_355_list_1.html\" data-link=\"355\" data-letter=\"B\">波导</a><a href=\"/cell_phone_index/subcate57_41148_list_1.html\" data-link=\"41148\" data-letter=\"D\">大松</a><a href=\"/cell_phone_index/subcate57_57930_list_1.html\" data-link=\"57930\" data-letter=\"I\">IPRO</a><a href=\"/cell_phone_index/subcate57_58347_list_1.html\" data-link=\"58347\" data-letter=\"V\">VIKK</a><a href=\"/cell_phone_index/subcate57_57491_list_1.html\" data-link=\"57491\" data-letter=\"D\">DOOGEE</a><a href=\"/cell_phone_index/subcate57_35102_list_1.html\" data-link=\"35102\" data-letter=\"N\">尼凯恩</a><a href=\"/cell_phone_index/subcate57_41365_list_1.html\" data-link=\"41365\" data-letter=\"Y\">易百年</a><a href=\"/cell_phone_index/subcate57_35405_list_1.html\" data-link=\"35405\" data-letter=\"Y\">誉品</a><a href=\"/cell_phone_index/subcate57_56216_list_1.html\" data-link=\"56216\" data-letter=\"L\">Librem</a><a href=\"/cell_phone_index/subcate57_35224_list_1.html\" data-link=\"35224\" data-letter=\"S\">SUGAR</a><a href=\"/cell_phone_index/subcate57_283_list_1.html\" data-link=\"283\" data-letter=\"F\">富士通</a><a href=\"/cell_phone_index/subcate57_35121_list_1.html\" data-link=\"35121\" data-letter=\"M\">MANN</a><a href=\"/cell_phone_index/subcate57_34906_list_1.html\" data-link=\"34906\" data-letter=\"B\">邦华</a></div>";
        Document doc = Jsoup.parse(str);
        Elements links = doc.getElementsByTag("a");
        for (Element link : links) {
            String linkHref = link.attr("href").split("\\/")[2].split("_list")[0];
            String linkText = link.text();
            System.out.println(linkHref + ":" + linkText);
        }
    }

    @Test
    public void testStr() {
        String str = "<table> \n" +
                " <tbody>\n" +
                "  <tr> \n" +
                "   <td class=\"hd\" colspan=\"2\" name=\"s-0\">基本参数</td> \n" +
                "  </tr> \n" +
                "  <tr> \n" +
                "   <th><span id=\"newPmName_0\">上市日期</span></th> \n" +
                "   <td class=\"hover-edit-param \"><span id=\"newPmVal_0\">2011年10月</span></td> \n" +
                "  </tr> \n" +
                "  <tr> \n" +
                "   <th><span id=\"newPmName_1\">手机类型</span></th> \n" +
                "   <td class=\"hover-edit-param \"><span id=\"newPmVal_1\"><a href=\"/cell_phone_index/subcate57_list_p38032_1.html\">3G手机&gt;</a>，<a href=\"/cell_phone_index/subcate57_list_s533_1.html\">智能手机&gt;</a>，<a href=\"/cell_phone_index/subcate57_list_s10078_1.html\">拍照手机&gt;</a></span></td> \n" +
                "  </tr> \n" +
                "  <tr> \n" +
                "   <th><span id=\"newPmName_2\">机身颜色</span></th> \n" +
                "   <td class=\"hover-edit-param \"><span id=\"newPmVal_2\">黑色，白色&nbsp;&nbsp;<a href=\"/362/361995/pic.shtml\">查看外观&gt;</a></span></td> \n" +
                "  </tr> \n" +
                " </tbody>\n" +
                "</table>";
        Document doc = Jsoup.parse(str);
        Elements trs = doc.select("table").select("tr");
        for (int i = 0; i < trs.size(); i++) {
            Elements ths = trs.get(i).select("th");
            Elements tds = trs.get(i).select("td");
            for (int j = 0; j < tds.size(); j++) {
                String title = "";
                if (ths.size() > 0) {
                    title = ths.get(j).text();
                }
                String text = tds.get(j).text();
                if (title.equals("上市日期")) {
                    System.out.println(title + ":" + text);
                }

            }
        }

    }
}
