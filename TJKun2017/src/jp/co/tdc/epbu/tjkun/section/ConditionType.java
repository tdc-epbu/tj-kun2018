/**
 *
 */
package jp.co.tdc.epbu.tjkun.section;

/**
 * @author t2011002
 *
 */
public enum ConditionType {

	// 検知
	/** 黒色検知 */
	BLACK_DETECTION,
	/** 灰色検知 */
	GRAY_DETECTION,
	/** 障害物検知 */
	OBSTACLES_DETECTION,
	/** 衝突検知 */
	COLLISION_DETECTION,

	// 実績
	/** 左回転数 */
	LEFT_DISTANCE,
	/** 左回転数 */
	RIGHT_DISTANCE,
	/** 経過時間(ミリ秒) */
	TIME,
	/** しっぽ角度*/
	TAIL_ANGLE,
	/** ライン未検知からの経過時間(ミリ秒) */
	WHITE_DURATION;

}
