package com.aiitec.base.model.comm;

import com.aiitec.base.annotation.NoConfound;

/**
 * Where条件
 * @param <WHERE>
 */
@NoConfound
public class Table<WHERE>{
    public int pa =1;
    public int li=20;
    public int ob= 0;
    public int ot=0;
    public WHERE where;

    public Table(WHERE where){
        this.where = where;
    }
}
