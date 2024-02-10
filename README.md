# 나만의 몰루 사이트 백엔드 서버
- 윈도우 / 맥 두집 살림을 위해 yml 파일로 환경변수 설정했으니 참고
- 23.11.24 추가 기능
  - 픽시브 크롤링 API 구현 초기 단계
    - 셀레니움을 이용해 이미지 주소 긁어오기 성공
    - 현재 수동으로 마우스 스크롤해야 이미지 주소를 온전히 긁어옴
      -> 자동으로 마우스 스크롤 기능 필요
  - 윈도우 / 맥 두집 살림을 위해 사용할 config 설정 적용
- 23.11.27 추가 기능
  - 셀레니움으로 마우스 스크롤하는 스크립트 실행, 자동으로 이미지 주소 긁어오기 성공
  - 이미지 주소로 짤 렌더링은 픽시브의 nginx 설정에 의해 실패
    -> 다른 접근 방법 필요
- 23.11.30 추가 기능
  - 이미지를 자동으로 저장하는 기능 구현
  - 픽시브 몰루 일러스트 탭의 1페이지 60장을 저장
- 23.12.02 추가 기능
  - 다운로드 받은 이미지를 렌더링하는 페이지 추가
- 23.12.14 추가 기능
  - 버그 수정
    - 현재 런타임 시점에 추가 된 이미지는 렌더링 불가능 <br/> 
      -> 리소스 핸들러 추가로 빌드 이후 추가 된 이미지도 렌더링 가능
- 23.12.16 추가 기능
  - config 파일에 OS 별로 yml 분리해서 환경 변수 설정
    - WebConfig, SeleniumConfig 에 적용
- 다음 목표
  - 현재 비로그인 상태로 이미지를 저장하는거라 r-18 이미지는 저장할 수 없음
    - 로그인기능도 포함하여 r-18 이미지 저장 기능 구현
  - 리액트를 이용한 프론트엔드 서버와 연동
