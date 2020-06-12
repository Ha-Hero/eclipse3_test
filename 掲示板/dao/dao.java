package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.bean;

public class dao {
	//①DBアクセスに必要な情報の定数を定義

	//接続先DBのURL(jdbc:mysql://[ホスト名orIPアドレス]:[ポート番号]/[データベース名]?serverTimezone=JST)
	private static final String url = "jdbc:mysql://localhost:3306/javatask?serverTimezone=JST";
	//ユーザ
	private static final String user = "root";
	//パスワード
	private static final String pw = "120614isozin";

	public static void addTask(String name,String mail,String form){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			// ②JDBCドライバをロードする
			Class.forName("com.mysql.cj.jdbc.Driver");
			// ③DBMSとの接続を確立する
			con = DriverManager.getConnection(url,user,pw);
			// ④SQL文を作成する
			String sql = "INSERT INTO javatask(name,mail,form,time) VALUE(?,?,?,now());";
			// ⑤SQL文を実行するための準備を行う
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, mail);
			pstmt.setString(3, form);
			// ⑥SQL文を実行してDBMSから結果を受信する
			pstmt.executeUpdate();
			// ⑦実行結果を含んだインスタンスからデータを取り出す
		} catch (ClassNotFoundException e) {
			System.out.println("JDBCドライバが見つかりません。");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("DBアクセス時にエラーが発生しました。");
			e.printStackTrace();
		} finally {
			// ⑧DBMSから切断する
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				System.out.println("DBアクセス時にエラーが発生しました。");
				e.printStackTrace();
			}
			try {
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (SQLException e) {
				System.out.println("DBアクセス時にエラーが発生しました。");
				e.printStackTrace();
			}
			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				System.out.println("DBアクセス時にエラーが発生しました。");
				e.printStackTrace();
			}
		}
	}
//---------------------------------------------------------------------------------

	public static ArrayList<bean> selectTask(){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<bean> result = new ArrayList<bean>();

		try {
			// ②JDBCドライバをロードする
			Class.forName("com.mysql.cj.jdbc.Driver");
			// ③DBMSとの接続を確立する
			con = DriverManager.getConnection(url,user,pw);
			// ④SQL文を作成する
			String sql = "SELECT * FROM javatask";
			// ⑤SQL文を実行するための準備を行う
			pstmt = con.prepareStatement(sql);
			// ⑥SQL文を実行してDBMSから結果を受信する
			rs = pstmt.executeQuery();
			// ⑦実行結果を含んだインスタンスからデータを取り出す
			while(rs.next()){
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String mail = rs.getString("mail");
				String form = rs.getString("form");
				String time = rs.getString("time");


				result.add(new bean(id,name,mail,form,time));
			}
		} catch (ClassNotFoundException e) {
			System.out.println("JDBCドライバが見つかりません。");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("DBアクセス時にエラーが発生しました。");
			e.printStackTrace();
		} finally {
			// ⑧DBMSから切断する
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				System.out.println("DBアクセス時にエラーが発生しました。");
				e.printStackTrace();
			}
			try {
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (SQLException e) {
				System.out.println("DBアクセス時にエラーが発生しました。");
				e.printStackTrace();
			}
			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				System.out.println("DBアクセス時にエラーが発生しました。");
				e.printStackTrace();
			}
		}
		return result;
	}

//-------------------------------------------------------------------------------

	public static void deleteTask(int id){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int t = 0;
		ArrayList<bean> result = new ArrayList<bean>();

		try {
			// ②JDBCドライバをロードする
			Class.forName("com.mysql.cj.jdbc.Driver");
			// ③DBMSとの接続を確立する
			con = DriverManager.getConnection(url,user,pw);
			// ④SQL文を作成する
			String sql = "DELETE FROM javatask WHERE id = ?";
			// ⑤SQL文を実行するための準備を行う
			pstmt = con.prepareStatement(sql);

			pstmt.setInt(1, id);

			// ⑥SQL文を実行してDBMSから結果を受信する

			pstmt.executeUpdate();


		} catch (ClassNotFoundException e) {
			System.out.println("JDBCドライバが見つかりません。");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("DBアクセス時にエラーが発生しました。");
			e.printStackTrace();
		} finally {
			// ⑧DBMSから切断する
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				System.out.println("DBアクセス時にエラーが発生しました。");
				e.printStackTrace();
			}
			try {
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (SQLException e) {
				System.out.println("DBアクセス時にエラーが発生しました。");
				e.printStackTrace();
			}
			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				System.out.println("DBアクセス時にエラーが発生しました。");
				e.printStackTrace();
			}
		}
	}

}