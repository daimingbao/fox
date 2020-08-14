package cn.supfox.algorithm.loadbalance;


public interface Rule {

    Server choose(Object key);

    void setLoadBalancer(LoadBalancer loadBalancer);

    LoadBalancer getLoadBalancer();
}
