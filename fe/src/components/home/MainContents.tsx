import React from 'react';
import Hero from './mainComponents/Hero';
import NearbyLocation from './mainComponents/NearbyLocation';
import HouseType from './mainComponents/HouseType';
import BeingHost from './mainComponents/BeingHost';
import styled from 'styled-components';

const MainContents = (): React.ReactElement => {
    return (
        <MainPage>
            <Hero />
            <NearbyLocation />
            <HouseType />
            <BeingHost />
        </MainPage>
    );
};

export default MainContents;

const MainPage = styled.main``;