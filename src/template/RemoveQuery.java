package template;

import java.sql.SQLException;

import domain.MemberBean;
import enums.MemberQuery;
import factory.DatabaseFactory;

public class RemoveQuery extends QueryTemplate{

	@Override
	void initialize() {
		map.put("sql",String.format(MemberQuery.DELETE.toString()));
	}

	@Override
	void startPlay() {
		try {
			mem = (MemberBean) map.get("bean");
			pstmt.setString(1, mem.getUserid());
			pstmt.setString(2, mem.getPassword());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	void endPlay() {
		try {
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
