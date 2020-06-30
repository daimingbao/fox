package com.fox.test;

public class Cinema {

    private Movie movie;

    private VR vr;

    public Cinema(Movie movie, VR vr) {
        this.movie = movie;
        this.vr = vr;
    }

    public void readAll() {

        //判断电影是否是播放中
        boolean enLecture = movie.getEnLecture();
        //播放中
        if (enLecture) {
            throw new FilmDejeEnLecture("电影播放中");
        }
        //播放电影
        movie.read();
        //开始vr游戏
        vr.startGame();
    }
}
