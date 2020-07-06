package com.example.sendme.adapter;

import java.io.Serializable;

public class Ticket implements Serializable {
    private String mId;
    private String mTgl;
    private String mAsal;
    private String m7an;
    private String mDws;
    private String mAnk;
    private String mHrgDws;
    private String mHrgAnk;
    private String mTot;
    private String key;

    public String getmId() {
        return mId;
    }

    public void setmId(String mId) {
        this.mId = mId;
    }

    public String getmTgl() {
        return mTgl;
    }

    public void setmTgl(String mTgl) {
        this.mTgl = mTgl;
    }

    public String getmAsal() {
        return mAsal;
    }

    public void setmAsal(String mAsal) {
        this.mAsal = mAsal;
    }

    public String getM7an() {
        return m7an;
    }

    public void setM7an(String m7an) {
        this.m7an = m7an;
    }

    public String getmDws() {
        return mDws;
    }

    public void setmDws(String mDws) {
        this.mDws = mDws;
    }

    public String getmAnk() {
        return mAnk;
    }

    public void setmAnk(String mAnk) {
        this.mAnk = mAnk;
    }

    public String getmHrgDws() {
        return mHrgDws;
    }

    public void setmHrgDws(String mHrgDws) {
        this.mHrgDws = mHrgDws;
    }

    public String getmHrgAnk() {
        return mHrgAnk;
    }

    public void setmHrgAnk(String mHrgAnk) {
        this.mHrgAnk = mHrgAnk;
    }

    public String getmTot() {
        return mTot;
    }

    public void setmTot(String mTot) {
        this.mTot = mTot;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
