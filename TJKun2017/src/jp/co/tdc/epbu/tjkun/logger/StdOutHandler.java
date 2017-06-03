package jp.co.tdc.epbu.tjkun.logger;

import java.util.logging.Level;
import java.util.logging.StreamHandler;


/**
 *  標準出力へログ出力するハンドラするクラスです。
 *  このクラスがないと標準出力エラーとなってしまいます。
 */
public class StdOutHandler extends StreamHandler {
 {
 // 標準出力への出力設定
 setOutputStream(System.out);
 // ログレベルの設定（ALLに設定しないとログレベルをコントロールできない）
 setLevel(Level.ALL);
 }
}