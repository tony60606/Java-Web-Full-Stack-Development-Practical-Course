package com.sample.DAO;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.SQLInvalidAuthorizationSpecException;
import java.sql.Statement;
import java.util.Objects;
import org.mindrot.jbcrypt.BCrypt;

import com.mysql.cj.jdbc.exceptions.MySQLQueryInterruptedException;
import com.sample.model.Member;
import com.sample.util.DButil;

public class MemberDAO {
	
	public static class RegisterResult {
		private final Long memberID ;
		private final String status ;
		private final String message ;
		
		public RegisterResult(Long memberID, String status, String message) {
			super();
			this.memberID = memberID;
			this.status = status;
			this.message = message;
		}

		public Long getMemberID() {
			return memberID;
		}

		public String getStatus() {
			return status;
		}

		public String getMessage() {
			return message;
		}
		
		public boolean isok() {
			return "OK".equalsIgnoreCase(status) ;
		}
		
	}
	
	public RegisterResult registerWithBCryptTx(Member m , String plainPassword) {
		// 檢查參數是否非空值，如果傳入了空值，程式會立刻拋出 NullPointerException
		Objects.requireNonNull(m,"Member") ;
		Objects.requireNonNull(plainPassword,"plainPassword") ;
		
		// 密碼加密
		// Salt（鹽值）：在密碼學中，鹽是指一串隨機產生的字串。將鹽與明文密碼混和後再進行雜湊，
		//             可以有效防止駭客使用「彩虹表（Rainbow Tables）」進行暴力破解。
		// 工作因子（Work Factor / Cost Factor，此處為 12）：這是 BCrypt 的特大優勢。
		//           數字越大，演算法執行的疊代次數就越多（計算複雜度呈指數成長）。
		//           設定為 12 代表演算法會進行 $2^{12} (4096)$ 次迴圈運算。
		
		String hash = BCrypt.hashpw(plainPassword,BCrypt.gensalt(12)) ;
		
		String sql = "INSERT INTO　members(email,password_hash,display_name,phone) VALUES (?,?,?,?)" ;
		
		Connection conn = null ;
		try {
			conn = DButil.getConnection() ;
			
			conn.setAutoCommit(false); 
			
			try (PreparedStatement pstmt = conn.prepareStatement(sql , Statement.RETURN_GENERATED_KEYS)){
				pstmt.setString(1, m.getEmail());
				pstmt.setString(2, hash);
				pstmt.setString(3, m.getDisplayname());
				pstmt.setString(4, m.getPhone());
				
				pstmt.executeLargeUpdate() ;
				
				long newID ;
				try (ResultSet rs = pstmt.getGeneratedKeys()){
					if(!rs.next()) {
						throw new SQLException("未產生新ID") ;
					}
					newID = rs.getLong(1) ;
				}
				conn.commit();
				return new RegisterResult(newID, "OK" , "REGISTERED") ;
			} 
			
		} catch (SQLIntegrityConstraintViolationException ex) {
			rollbackQuietly(conn);
			return new RegisterResult(null, "FAILED", "EMAIL_EXIST") ;
		} catch (SQLException ex) {
			rollbackQuietly(conn);
			throw new RuntimeException(ex) ;
		} finally {
			if (conn != null) {
				try {
					conn.setAutoCommit(true);
					conn.close();
				}catch(SQLException ex) {
					System.out.println(ex) ;
				}
			}
			
		}
			
	}
	
	private void rollbackQuietly(Connection conn) {
		if (conn != null) {
			try {
				conn.rollback();
			} catch(SQLException ignore) {
				
			}
			
		}
		
	}
	
	
}
