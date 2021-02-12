package bg.softuni.mobilele.service.impl;

import bg.softuni.mobilele.model.entities.OfferEntity;
import bg.softuni.mobilele.model.service.OfferAddServiceModel;
import bg.softuni.mobilele.model.view.OfferSummaryViewModel;
import bg.softuni.mobilele.repository.ModelRepository;
import bg.softuni.mobilele.repository.OfferRepository;
import bg.softuni.mobilele.repository.UserRepository;
import bg.softuni.mobilele.security.CurrentUser;
import bg.softuni.mobilele.service.OfferService;

import java.time.Instant;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class OfferServiceImpl implements OfferService {

  private final OfferRepository offerRepository;
  private final ModelMapper modelMapper;
  private final CurrentUser currentUser;
  private final ModelRepository modelRepository;
  private final UserRepository userRepository;

  public OfferServiceImpl(OfferRepository offerRepository, ModelMapper modelMapper, CurrentUser currentUser, ModelRepository modelRepository, UserRepository userRepository) {
    this.offerRepository = offerRepository;
    this.modelMapper = modelMapper;
    this.currentUser = currentUser;
    this.modelRepository = modelRepository;
    this.userRepository = userRepository;
  }

  @Override
  public List<OfferSummaryViewModel> getAllOffers() {
    //TODO - implement mapping
    throw new UnsupportedOperationException("Coming soon :-)");
  }

  @Override
  public Long save(OfferAddServiceModel model) {
    OfferEntity offerEntity = asNewEntity(model);
    OfferEntity newEntity = this.offerRepository.save(offerEntity);

    return newEntity.getId();

  }
  private OfferEntity asNewEntity(OfferAddServiceModel model) {
    OfferEntity offerEntity = new OfferEntity();
    this.modelMapper.map(model,offerEntity);

    offerEntity.setId(null);
    offerEntity.setModel(modelRepository.findById(model.getModelId()).orElseThrow());
    offerEntity.setUser(userRepository.findByUsername(currentUser.getName()).orElseThrow());
    offerEntity.setCreated(Instant.now());
    offerEntity.setUpdated(Instant.now());
    return offerEntity;
  }
}
