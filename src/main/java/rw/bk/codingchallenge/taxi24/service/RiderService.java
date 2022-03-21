package rw.bk.codingchallenge.taxi24.service;

import org.springframework.stereotype.Service;
import rw.bk.codingchallenge.taxi24.domain.Rider;
import rw.bk.codingchallenge.taxi24.dto.RiderDto;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public interface RiderService {

    RiderDto createOne(RiderDto riderDto) throws InvocationTargetException, IllegalAccessException;

    RiderDto findByNationalId(String nationalId) throws InvocationTargetException, IllegalAccessException;

    List<Rider> findAllRiders();
}
