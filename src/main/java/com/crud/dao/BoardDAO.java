package com.crud.dao;

import com.crud.bean.BoardVO;
import com.crud.common.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BoardDAO {
	
	Connection conn = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;

	private final String BOARD_INSERT = "insert into Friends (name, hguid, age, gender, email, major, rc, nickname, club) values (?,?,?,?,?,?,?,?,?)";
	private final String BOARD_UPDATE = "update Friends set name=?, hguid=?, age=?, gender=?,email=?, major=?, rc=?, nickname=?, club=? where id=?";
	private final String BOARD_DELETE = "delete from Friends  where id=?";
	private final String BOARD_GET = "select * from Friends  where id=?";
	private final String BOARD_LIST = "select * from Friends order by id desc";

	public int insertBoard(BoardVO vo) {
		System.out.println("===> JDBC로 insertBoard() 기능 처리");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_INSERT);
			stmt.setString(1, vo.getName());
			stmt.setString(2, vo.getHguid());
			stmt.setInt(3, vo.getAge());
			stmt.setString( 4, vo.getGender());
			stmt.setString( 5, vo.getEmail());
			stmt.setString( 6, vo.getMajor());
			stmt.setString( 7, vo.getRc());
			stmt.setString( 8, vo.getNickname());
			stmt.setString( 9, vo.getClub());
			stmt.executeUpdate();
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	// 글 삭제
	public void deleteBoard(BoardVO vo) {
		System.out.println("===> JDBC로 deleteBoard() 기능 처리");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_DELETE);
			stmt.setInt(1, vo.getId());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public int updateBoard(BoardVO vo) {
		System.out.println("===> JDBC로 updateBoard() 기능 처리");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_UPDATE);
			stmt.setString(1, vo.getName());
			stmt.setString(2, vo.getHguid());
			stmt.setInt(3, vo.getAge());
			stmt.setString( 4, vo.getGender());
			stmt.setString( 5, vo.getEmail());
			stmt.setString( 6, vo.getMajor());
			stmt.setString( 7, vo.getRc());
			stmt.setString( 8, vo.getNickname());
			stmt.setString( 9, vo.getClub());
			stmt.setInt(10, vo.getId());
			
			
			System.out.println(vo.getName() + "-" + vo.getHguid()+ "-" + vo.getAge() + "-"+ vo.getGender() + "-"+ vo.getEmail() + "-"+ vo.getMajor() + "-"+ vo.getRc() + "-"
					+ vo.getNickname() + "-" + vo.getClub() + "-"+ vo.getId());
			stmt.executeUpdate();
			return 1;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}	
	
	public BoardVO getBoard(int id) {
		BoardVO one = new BoardVO();
		System.out.println("===> JDBC로 getBoard() 기능 처리");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_GET);
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			if(rs.next()) {
				one.setId(rs.getInt("id"));
				one.setName(rs.getString("name"));
				one.setHguid(rs.getString("hguid"));
				one.setAge(rs.getInt("age"));
				one.setGender(rs.getString("gender"));
				one.setEmail(rs.getString("email"));
				one.setMajor(rs.getString("major"));
				one.setRc(rs.getString("rc"));
				one.setNickname(rs.getString("nickname"));
				one.setClub(rs.getString("club"));
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return one;
	}
	
	public List<BoardVO> getBoardList(){
		List<BoardVO> list = new ArrayList<BoardVO>();
		System.out.println("===> JDBC로 getBoardList() 기능 처리");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_LIST);
			rs = stmt.executeQuery();
			while(rs.next()) {
				BoardVO one = new BoardVO();
				one.setId(rs.getInt("id"));
				one.setName(rs.getString("name"));
				one.setHguid(rs.getString("hguid"));
				one.setAge(rs.getInt("age"));
				one.setGender(rs.getString("gender"));
				one.setEmail(rs.getString("email"));
				one.setMajor(rs.getString("major"));
				one.setRc(rs.getString("rc"));
				one.setNickname(rs.getString("nickname"));
				one.setClub(rs.getString("club"));
				list.add(one);
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return list;
	}
}
