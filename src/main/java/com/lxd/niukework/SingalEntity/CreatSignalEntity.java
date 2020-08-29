package com.lxd.niukework.SingalEntity;

public class CreatSignalEntity {
    private static volatile CreatSignalEntity creatSignalEntity;
    private CreatSignalEntity(){};
    public static CreatSignalEntity get(){
        if(creatSignalEntity==null){
            synchronized (CreatSignalEntity.class){
                if(creatSignalEntity==null){
                    creatSignalEntity = new CreatSignalEntity();
                }
            }
        }
        return creatSignalEntity;
    }
}
