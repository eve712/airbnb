import React from 'react';
import styled from 'styled-components';
import CityCard from './CityCard';
import cityData from '../../../utils/mock/city-card.json';
const CityTour = () => {
  return (
    <CityTourDiv>
      <CityTitle>가까운 여행지 둘러보기</CityTitle>
      <CityCardFrame>
        {cityData.map((cityCard, idx) => (
          <CityCard
            key={idx}
            cityImg={cityCard.imgUrl}
            cityName={cityCard.name}
            cityDistance={cityCard.distance}
          ></CityCard>
        ))}
      </CityCardFrame>
    </CityTourDiv>
  );
};

const CityTourDiv = styled.div`
  margin: 0rem auto 5rem auto;
  width: 88.88%;
`;
const CityCardFrame = styled.div`
  display: grid;
  grid-template-columns: 1fr 1fr 1fr 1fr;
  grid-template-rows: 1fr 1fr;
  grid-gap: 1rem;
`;
const CityTitle = styled.div`
  margin-bottom: 2rem;
  color: ${({ theme }) => theme.colors.gray1};
  font-size: ${({ theme }) => theme.fontSizes.XL};
`;

export default CityTour;
