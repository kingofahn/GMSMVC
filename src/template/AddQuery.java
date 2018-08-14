package template;

import java.sql.SQLException;

import domain.ImageBean;
import domain.MemberBean;
import enums.MemberQuery;
import factory.DatabaseFactory;

public class AddQuery extends QueryTemplate {

	@Override
	void initialize() {
		switch (map.get("table").toString()) {
		case "member":
			map.put("sql", MemberQuery.INSERT.toString());
			break;
		case "image":
			map.put("sql", String.format(MemberQuery.UPLOAD.toString()));
			break;
		default:
			break;
		}
	}

	@Override
	void startPlay() {
		switch (map.get("table").toString()) {
		case "member":
			try {
				pstmt = DatabaseFactory.createDatabase2(map).getConnection().prepareStatement((String) map.get("sql"));
				mem = (MemberBean) map.get("bean");
				pstmt.setString(1, mem.getUserid());
				pstmt.setString(2, mem.getSsn());
				pstmt.setString(3, mem.getName());
				pstmt.setString(4, mem.getRoll());
				pstmt.setString(5, mem.getTeamid());
				pstmt.setString(6, mem.getPassword());
				pstmt.setString(7, mem.getAge());
				pstmt.setString(8, mem.getGender());
				pstmt.setString(9, mem.getSubject());
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
			break;
		case "image":
			pStmtInit();
			try {
				bean = (ImageBean) map.get("bean");
				pstmt.setString(1, bean.getImgname());
				pstmt.setString(2, bean.getExtension());
				pstmt.setString(3, bean.getUserid());
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;
		default:
			break;
		}
	}

	@Override
	void endPlay() {
		try {
			pstmt.executeQuery();
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
	}
}
