package com.example.liuliang.recylerviewtest210;

/**
 * Created by Neusoft on 2017/4/5.
 */

class ArticleBean {
    private int articleId;//文章id
    private String title;//文章标题
    private int imgid;//文章图片id，本例使用静态图片
    private String time;//文章时间
    private String description;//文章描述

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImgid() {
        return imgid;
    }

    public void setImgid(int imgid) {
        this.imgid = imgid;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }


    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }
}
