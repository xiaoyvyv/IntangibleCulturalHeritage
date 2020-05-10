package com.xiaoyv.cultureengine;

import com.blankj.utilcode.util.PathUtils;
import com.xiaoyv.cultureengine.module.main.found.comment.FoundCommentModule;
import com.xiaoyv.cultureengine.module.main.found.hot.FoundHotModule;
import com.xiaoyv.cultureengine.module.main.found.page.FoundPageModule;
import com.xiaoyv.cultureengine.module.main.found.page.works.FoundPageDetailsModule;
import com.xiaoyv.cultureengine.module.main.found.video.FoundVideoModule;
import com.xiaoyv.cultureengine.module.main.home.BannerModule;
import com.xiaoyv.cultureengine.module.main.home.HomeItemModule;
import com.xiaoyv.cultureengine.module.main.make.MineMakeModule;
import com.xiaoyv.cultureengine.module.main.mine.attention.MineAttentionModule;
import com.xiaoyv.cultureengine.module.main.mine.collection.MineCollectionModule;
import com.xiaoyv.cultureengine.module.main.mine.dynamic.MineDynamicModule;
import com.xiaoyv.cultureengine.module.main.mine.fans.MineFansModule;
import com.xiaoyv.cultureengine.module.main.mine.history.MineHistoryModule;
import com.xiaoyv.cultureengine.module.main.mine.message.MineMessageModule;
import com.xiaoyv.cultureengine.module.main.news.NewsPageModule;

public class CultureEngineManager {

    /**
     * 数据缓存文件夹
     */
    static String HTTP_CACHE_DIR = PathUtils.getExternalAppCachePath();

    /**
     * Banner 相关服务
     */
    private static volatile BannerModule bannerModule;

    public static BannerModule getBannerModule() {
        if (bannerModule == null) {
            synchronized (BannerModule.class) {
                if (bannerModule == null) {
                    bannerModule = new BannerModule();
                }
            }
        }
        return bannerModule;
    }


    /**
     * 主页条目 相关服务
     */
    private static volatile HomeItemModule homeItemModule;

    public static HomeItemModule getHomeItemModule() {
        if (homeItemModule == null) {
            synchronized (HomeItemModule.class) {
                if (homeItemModule == null) {
                    homeItemModule = new HomeItemModule();
                }
            }
        }
        return homeItemModule;
    }

    /**
     * 资讯页面 相关服务
     */
    private static volatile NewsPageModule newsPageModule;

    public static NewsPageModule getNewsPageModule() {
        if (newsPageModule == null) {
            synchronized (NewsPageModule.class) {
                if (newsPageModule == null) {
                    newsPageModule = new NewsPageModule();
                }
            }
        }
        return newsPageModule;
    }

    /**
     * 我的页面 我的消息 相关服务
     */
    private static volatile MineMessageModule mineMessageModule;

    public static MineMessageModule getMineMessageModule() {
        if (mineMessageModule == null) {
            synchronized (MineMessageModule.class) {
                if (mineMessageModule == null) {
                    mineMessageModule = new MineMessageModule();
                }
            }
        }
        return mineMessageModule;
    }

    /**
     * 我的页面 粉丝 相关服务
     */
    private static volatile MineFansModule mineFansModule;

    public static MineFansModule getMineFansModule() {
        if (mineFansModule == null) {
            synchronized (MineFansModule.class) {
                if (mineFansModule == null) {
                    mineFansModule = new MineFansModule();
                }
            }
        }
        return mineFansModule;
    }

    /**
     * 我的页面 关注 相关服务
     */
    private static volatile MineAttentionModule mineAttentionModule;

    public static MineAttentionModule getMineAttentionModule() {
        if (mineAttentionModule == null) {
            synchronized (MineAttentionModule.class) {
                if (mineAttentionModule == null) {
                    mineAttentionModule = new MineAttentionModule();
                }
            }
        }
        return mineAttentionModule;
    }

    /**
     * 我的页面 收藏 相关服务
     */
    private static volatile MineCollectionModule mineCollectionModule;

    public static MineCollectionModule getMineCollectionModule() {
        if (mineCollectionModule == null) {
            synchronized (MineCollectionModule.class) {
                if (mineCollectionModule == null) {
                    mineCollectionModule = new MineCollectionModule();
                }
            }
        }
        return mineCollectionModule;
    }

    /**
     * 我的页面 历史记录 相关服务
     */
    private static volatile MineHistoryModule mineHistoryModule;

    public static MineHistoryModule getMineHistoryModule() {
        if (mineHistoryModule == null) {
            synchronized (MineHistoryModule.class) {
                if (mineHistoryModule == null) {
                    mineHistoryModule = new MineHistoryModule();
                }
            }
        }
        return mineHistoryModule;
    }
    /**
     * 我的页面 我的动态 相关服务
     */
    private static volatile MineDynamicModule mineDynamicModule;

    public static MineDynamicModule getMineDynamicModule() {
        if (mineDynamicModule == null) {
            synchronized (MineDynamicModule.class) {
                if (mineDynamicModule == null) {
                    mineDynamicModule = new MineDynamicModule();
                }
            }
        }
        return mineDynamicModule;
    }

    /**
     * 我的页面 我的动态 相关服务
     */
    private static volatile MineMakeModule mineMakeModule;

    public static MineMakeModule getMineMakeModule() {
        if (mineMakeModule == null) {
            synchronized (MineMakeModule.class) {
                if (mineMakeModule == null) {
                    mineMakeModule = new MineMakeModule();
                }
            }
        }
        return mineMakeModule;
    }

    /**
     * 发现页面 精选文章 相关服务
     */
    private static volatile FoundHotModule foundHotModule;

    public static FoundHotModule getFoundHotModule() {
        if (foundHotModule == null) {
            synchronized (FoundHotModule.class) {
                if (foundHotModule == null) {
                    foundHotModule = new FoundHotModule();
                }
            }
        }
        return foundHotModule;
    }

    /**
     * 发现页面 精选文章评论 相关服务
     */
    private static volatile FoundCommentModule foundCommentModule;

    public static FoundCommentModule getFoundCommentModule() {
        if (foundCommentModule == null) {
            synchronized (FoundCommentModule.class) {
                if (foundCommentModule == null) {
                    foundCommentModule = new FoundCommentModule();
                }
            }
        }
        return foundCommentModule;
    }

    /**
     * 发现页面 热门视频 相关服务
     */
    private static volatile FoundVideoModule foundVideoModule;

    public static FoundVideoModule getFoundVideoModule() {
        if (foundVideoModule == null) {
            synchronized (FoundVideoModule.class) {
                if (foundVideoModule == null) {
                    foundVideoModule = new FoundVideoModule();
                }
            }
        }
        return foundVideoModule;
    }


    /**
     * 发现页面 非遗传承 相关服务
     */
    private static volatile FoundPageModule foundPageModule;

    public static FoundPageModule getFoundPageModule() {
        if (foundPageModule == null) {
            synchronized (FoundPageModule.class) {
                if (foundPageModule == null) {
                    foundPageModule = new FoundPageModule();
                }
            }
        }
        return foundPageModule;
    }


    /**
     * 发现页面 非遗传承作品展 相关服务
     */
    private static volatile FoundPageDetailsModule foundPageDetailsModule;

    public static FoundPageDetailsModule getFoundPageDetailsModule() {
        if (foundPageDetailsModule == null) {
            synchronized (FoundPageDetailsModule.class) {
                if (foundPageDetailsModule == null) {
                    foundPageDetailsModule = new FoundPageDetailsModule();
                }
            }
        }
        return foundPageDetailsModule;
    }


}
