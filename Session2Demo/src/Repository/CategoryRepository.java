package Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Connect.ConnectDB;
import Entity.CategoryEntity;

public class CategoryRepository implements IGenericRepository<CategoryEntity, Integer> {

	@Override
	public List<CategoryEntity> find() {
		List<CategoryEntity> list = new ArrayList<>();
		Connection conn = ConnectDB.openDB();
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM Category");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				CategoryEntity cat = new CategoryEntity();
				cat.setId(rs.getInt("id"));
				cat.setName(rs.getString("name"));
				cat.setStatus(rs.getInt("status"));
				cat.setParentId(rs.getInt("parentId"));
				list.add(cat);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public CategoryEntity findById(Integer id) {
		CategoryEntity cat = new CategoryEntity();
		Connection conn = ConnectDB.openDB();
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM Category WHERE id = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				cat.setId(rs.getInt("id"));
				cat.setName(rs.getString("name"));
				cat.setStatus(rs.getInt("status"));
				cat.setParentId(rs.getInt("parentId"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cat;
	}

	@Override
	public CategoryEntity add(CategoryEntity entity) {
		Connection conn = ConnectDB.openDB();
		try {
			PreparedStatement ps = conn.prepareStatement("INSERT INTO Category VALUES(?, ?, ?)");
			
			ps.setString(1, entity.getName());
			ps.setInt(2, entity.getStatus());
			ps.setInt(3, entity.getParentId());
			ps.executeUpdate();
			return entity;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public CategoryEntity update(CategoryEntity entity) {
		Connection conn = ConnectDB.openDB();
		try {
			PreparedStatement ps = conn.prepareStatement("UPDATE Category SET name=?, status=?, parentId WHERE id=?");
			ps.setString(1, entity.getName());
			ps.setInt(2, entity.getStatus());
			ps.setInt(3, entity.getStatus());
			ps.setInt(4, entity.getId());
			ps.executeUpdate();
			return entity;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Boolean remove(Integer id) {
		Connection conn = ConnectDB.openDB();
		try {
			PreparedStatement ps = conn.prepareStatement("DELETE FROM Category WHERE id = ?");
			ps.setInt(1, id);
			int rs = ps.executeUpdate();
			return rs > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}
