package com.fox.thread;

import java.util.concurrent.atomic.AtomicInteger;

public class SequenceProblem {


        private AtomicInteger first = new AtomicInteger(0);

        private AtomicInteger second = new AtomicInteger(0);

        public SequenceProblem() {

        }

        public void first(Runnable printFirst) throws InterruptedException {

            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            first.incrementAndGet();
        }

        public void second(Runnable printSecond) throws InterruptedException {
//            while(first.get() != 1) {
//
//            }
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            second.incrementAndGet();
        }

        public void third(Runnable printThird) throws InterruptedException {
//            while(second.get()!= 1) {
//
//            }
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
        }




    public static void main(String[] args) {
        SequenceProblem foo = new SequenceProblem();
        Runnable printer1 = new Runnable() {
            @Override
            public void run() {
                System.out.print("one");
            }
        };
        Runnable printer2 = new Runnable() {
            @Override
            public void run() {
                System.out.print("two");
            }
        };
        Runnable printer3 = new Runnable() {
            @Override
            public void run() {
                System.out.print("three");
            }
        };
        try {
            foo.first(printer1);
            foo.second(printer2);
            foo.third(printer3);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }



}
