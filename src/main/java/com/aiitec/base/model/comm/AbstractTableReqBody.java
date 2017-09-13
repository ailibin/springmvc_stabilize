package com.aiitec.base.model.comm;

import com.aiitec.base.annotation.NoConfound;

@NoConfound
public abstract class AbstractTableReqBody<WHERE> {
    public int action=1;
    public Table<WHERE> table;
    public AbstractTableReqBody(Table<WHERE> where){
        this.table=where;
    }
}
