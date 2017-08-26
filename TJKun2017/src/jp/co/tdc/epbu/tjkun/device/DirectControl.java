package jp.co.tdc.epbu.tjkun.device;

public interface DirectControl {
    /**
     * 左右のモーターを直接制御します。
     *
     * @param left
     *            左モーターパワー
     * @param right
     *            右モーターパワー
     * @param tail
     *            尻尾の角度
     */
    public void controlDirect(int left, int right, int tail);
}
