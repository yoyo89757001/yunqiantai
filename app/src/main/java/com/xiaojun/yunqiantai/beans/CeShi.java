package com.xiaojun.yunqiantai.beans;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;
import io.objectbox.annotation.Index;
import io.objectbox.annotation.IndexType;


/**
 * Created by Administrator on 2018/8/3.
 */
@Entity
public class CeShi {

    @Id(assignable = true)
    long id;
    //索引
    @Index(type = IndexType.HASH)
    String name;

    public CeShi(long id, String name) {
        this.id = id;
        this.name = name;
    }
}
