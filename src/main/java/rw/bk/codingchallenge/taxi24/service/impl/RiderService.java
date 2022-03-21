package rw.bk.codingchallenge.taxi24.service.impl;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.stereotype.Service;
import rw.bk.codingchallenge.taxi24.domain.Rider;
import rw.bk.codingchallenge.taxi24.dto.RiderDto;
import rw.bk.codingchallenge.taxi24.repository.RiderRepository;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;

@Service
public class RiderService implements rw.bk.codingchallenge.taxi24.service.RiderService {

    private final RiderRepository riderRepository;

    public RiderService(RiderRepository riderRepository) {
        this.riderRepository = riderRepository;
    }

    @Override
    public RiderDto createOne(RiderDto riderDto) throws InvocationTargetException, IllegalAccessException {
        Rider rider = new Rider();
        //Converting RiderDto request to Rider
        BeanUtils.copyProperties(rider, riderDto);
        rider.setRegistrationDate(new Date());
        Rider response = this.riderRepository.save(rider);

        //Converting Rider response to RiderSto
        BeanUtils.copyProperties(riderDto, response);

        return riderDto;
    }

    @Override
    public RiderDto findByNationalId(String nationalId) throws InvocationTargetException, IllegalAccessException {
        Rider rider = riderRepository.findByNationalId(nationalId);
        if (rider != null){
            RiderDto riderDto = new RiderDto();
            BeanUtils.copyProperties(riderDto, rider);
            return riderDto;
        }
        return null;
    }

    @Override
    public List<Rider> findAllRiders() {
        return this.riderRepository.findAll();
    }
}
