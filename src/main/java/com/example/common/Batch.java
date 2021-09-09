package com.example.common;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.example.domain.Vegetable;

public class Batch {
	public List<Vegetable> importCSV() {
		
		FileInputStream fi = null;
		InputStreamReader is = null;
		BufferedReader br = null;

		List<Vegetable> vegetableList = new ArrayList<Vegetable>();

		try {
			// 読み込みファイルのインスタンス生成
			// ファイル名を指定する
			fi = new FileInputStream("src/main/resources/static/batch/batchTest.csv");
			is = new InputStreamReader(fi);
			br = new BufferedReader(is);
			
			// 読み込み行
			String line;
			
			// 読み込み行数の管理
			int i = 0;
			
			// 列名を管理する為の配列
			String[] arr = null;

			// 1行ずつ読み込みを行う
			while((line = br.readLine()) != null) {
				Vegetable vegetable = new Vegetable();
				// 先頭行は列名
				if(i == 0) {
					// カンマで分割した内容を配列に確認する
					arr = line.split(",");
				} else {
					// データ内容をコンソールに表示する
					System.out.println("---------------------------------");
					
					// データ件数を表示
					System.out.println("データ" + i + "件目");
					
					// カンマで分割した内容を配列に確認する
					String[] data = line.split(",");
					System.out.println("data=" + data);
					
					// 配列の中身を順位表示する。列名(=列名を格納した配列の要素数)分繰り返す
					int colno = 0;
					for(String colmn : arr) {
						System.out.println(colmn + ":" + data[colno]);
						colno++;
					}
					vegetable.setName(data[0]);
					vegetable.setDescription(data[1]);
					vegetable.setPrice(Integer.parseInt(data[2]));
					vegetable.setColor(data[3]);
					vegetable.setDeleted(Boolean.valueOf(data[4]));
					
					vegetableList.add(vegetable);
				}
				// 行数のインクリメント
				i++;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return vegetableList;
	}
	
	public void exportCSV(List<Vegetable> vegetableList) {
		Date d = new Date();
		SimpleDateFormat d1 = new SimpleDateFormat("yyyyMMdd");
		String s = d1.format(d);

		try {
			// 出力ファイルの作成
			FileWriter fw = new FileWriter("order_" + s + ".csv", false);
			
			// PrintWriterクラスのオブジェクトを生成
			PrintWriter pw = new PrintWriter(new BufferedWriter(fw));
			
			// ヘッダーの指定
			pw.print("名前");
			pw.print(",");
			pw.print("説明");
			pw.print(",");
			pw.print("値段");
			pw.print(",");
			pw.print("色");
			pw.print(",");
			pw.print("削除判断");
			pw.println();
			
			// データを書き込む
			for(Vegetable vegetable : vegetableList) {
				pw.print(vegetable.getName() + ", ");
				pw.print(vegetable.getDescription() + ", ");
				pw.print(vegetable.getPrice() + ", ");
				pw.print(vegetable.getColor() + ", ");
				pw.print(vegetable.getDeleted());
				pw.println();
			}
			
			// ファイルを閉じる
			pw.close();
			
			// 出力確認用のメッセージ
			System.out.println("CSVファイルを出力しました");
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
	}
}
