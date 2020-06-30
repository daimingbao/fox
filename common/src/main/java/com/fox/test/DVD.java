package com.fox.test;

public class DVD implements Movie{
    private int duration;

    private boolean enReading;


    @Override
    public void read() {
        //判断电影是否是播放中
        boolean enLecture = getEnLecture();
        //播放中
        if (enLecture) {
            throw new FilmDejeEnLecture("电影开始播放了");
        }
        setEnReading(true);
        System.out.println("电影播放中");

        setEnReading(false);
        System.out.println("电影播放结束");

    }

    public int getDuree(){
        return duration;
    }

    public boolean getEnLecture() {
       return enReading;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setEnReading(boolean enReading) {
        this.enReading = enReading;
    }
}
