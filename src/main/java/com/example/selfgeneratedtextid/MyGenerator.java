package com.example.selfgeneratedtextid;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;
import java.util.stream.Stream;

public class MyGenerator implements IdentifierGenerator {
    private String prefix = "EMP";
    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object obj) throws HibernateException {
        String query = "SELECT u.id FROM User u";
        Stream<String> ids = session.createQuery(query, String.class).stream();// Thực hiện câu lệnh , lấy dc danh sách id
        // sau đó chuyển sang Stream => ids h là 1 stream
        Long max = ids.map(o -> o.replace(prefix, "")).mapToLong(Long::parseLong).max().orElse(0L);
        // .map thay thế prefix thành chuỗi rỗng
        // do đang là String nên mapToLong chuyển sang Long , max() lấy giá trị lớn nhất , nếu ko có trả về 0L
        return prefix + (String.format("%04d", max + 1));
        // trả về id dạng String 
    }
}
