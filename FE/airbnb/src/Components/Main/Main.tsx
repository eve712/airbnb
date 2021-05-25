import { useEffect } from "react";
import { useRecoilState } from "recoil";
import { mainState, errorState } from "./MainRecoil";
import GNB from "@/Components/GNB/GNB";
import Cities from "./Cities/Cities";
import Accomodations from "./Accomodations/Accomodations";
import Footer from "./Footer/Footer";
import { getAPI } from "@/Utils/api";
import { Main as S } from "./MainStyles";

const Main = () => {
  const [mainData, setData] = useRecoilState(mainState);
  const [error, setError] = useRecoilState(errorState);

  useEffect(() => {
    getAPI
      .main()
      .then((res) => res.json())
      .then((json) => {
        if (json) setData(json);
        else throw Error();
      })
      .catch((err) => setError(err));
  }, [setData, setError]);

  if (error || !mainData) return null;

  return (
    <S.Main>
      <GNB />
      <S.HiroImage src={mainData.hiroImage} alt="hiroImage" />
      <Cities cities={mainData.cities} />
      <Accomodations accomodations={mainData.categories} />
      <Footer />
    </S.Main>
  );
};

export default Main;
