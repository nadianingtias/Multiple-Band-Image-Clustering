/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MultibandImage;

/**
 *
 * @author Nadian
 */
public class Point {
    int[] mIndex; //1-6
    int  mLabel;

    public Point() {
    }
    
    public Point(int[] mIndex) {
        this.mIndex = mIndex;
    }

    public int[] getmIndex() {
        return mIndex;
    }

    public void setmIndex(int[] mIndex) {
        this.mIndex = mIndex;
    }

    public int getmLabel() {
        return mLabel;
    }

    public void setmLabel(int mLabel) {
        this.mLabel = mLabel;
    }
    
    
}
