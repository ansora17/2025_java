const GO_KEY =
	"qKhW5l3qMZ7vggfkiEeB%2FroS7hi%2BV2mYQVSFqnuBbsow954NYhnhwmoFYa7VYRgN0avF6WpT2K7FqLAxtAyoyA%3D%3D";

// ✅ 제목으로 contentId 찾기
async function searchByTitle() {
	const title = document.getElementById("title").value.trim();
	if (!title) return;

	const searchUrl = `https://apis.data.go.kr/B551011/KorService1/searchKeyword1?numOfRows=1&pageNo=1&MobileOS=ETC&MobileApp=AppTest&ServiceKey=${GO_KEY}&listYN=Y&arrange=A&keyword=${encodeURIComponent(title)}&_type=json`;

	try {
		const res = await axios.get(searchUrl);
		const item = res.data.response.body.items.item[0];
		const contentId = item.contentid;

		// contentId로 상세정보 채우기
		fillTourData(contentId);

	} catch (err) {
		alert("해당 제목으로 여행지를 찾을 수 없습니다.");
		console.error("searchKeyword1 API 실패:", err);
	}
}

// ✅ contentId 기반 상세정보 → 폼에 자동 채우기
async function fillTourData(searchKeyword) {
	const detailUrl = `http://apis.data.go.kr/B551011/KorService1/searchKeyword1?numOfRows=12&pageNo=${page}&MobileOS=ETC&MobileApp=AppTest&ServiceKey=${GO_KEY}&listYN=Y&arrange=O&areaCode=&sigunguCode=&cat1=&cat2=&cat3=&keyword=${searchKeyword}&_type=json`;

	try {
		const res = await axios.get(detailUrl);
		const item = res.data.response.body.items.item[0];
		console.log(item.title)
		//document.getElementById("content").value = item.addr1 || "";
		document.getElementById("body").value = item.overview || "";
		document.getElementById("imageUrl").value = item.firstimage || "";

		console.log("✅ API 자동입력 완료!");

	} catch (err) {
		console.error("상세 정보 API 실패", err);
	}
}

