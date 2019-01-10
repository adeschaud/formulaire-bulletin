package dao;

import java.sql.Connection;

import metier.Bulletin;

public class BulletinDAO extends DAO<Bulletin>{

	public BulletinDAO(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(Bulletin obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Bulletin read(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(Bulletin obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Bulletin obj) {
		// TODO Auto-generated method stub
		return false;
	}

}
