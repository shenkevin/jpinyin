package opensource.jpinyin;

import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.ZipInputStream;

/**
 * 资源文件加载类
 *
 * @author stuxuhai (dczxxuhai@gmail.com)
 * @version 1.0
 * @created 2013-5-15
 */
public class PinyinResource
{
    private static final Logger LOGGER = Logger.getLogger(PinyinResource.class.getName());

    private static Properties getResource(String resourceName)
    {
        ZipInputStream zip = new ZipInputStream(PinyinResource.class.getResourceAsStream(resourceName));

        try
        {
            zip.getNextEntry();
            Properties p = new Properties();
            p.load(zip);
            zip.close();
            return p;
        }
        catch (IOException e)
        {
            LOGGER.log(Level.WARNING, "Exception in loading PinyinResource", e);
        }
        return null;
    }

    protected static Properties getPinyinTable()
    {
        String resourceName = "/data/pinyin.db";
        return getResource(resourceName);
    }

    protected static Properties getMutilPintinTable()
    {
        String resourceName = "/data/mutil_pinyin.db";
        return getResource(resourceName);
    }

    protected static Properties getChineseTable()
    {
        String resourceName = "/data/chinese.db";
        return getResource(resourceName);
    }
}
