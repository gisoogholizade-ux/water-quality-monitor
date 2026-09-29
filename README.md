# Water Quality Monitor

سامانه سبک ثبت و تحلیل داده‌های کیفیت آب — پروژه تیم Nexora.

## وضعیت فعلی: 40%

تا این مرحله هسته سامانه، ثبت اندازه‌گیری، داشبورد، سوابق، جستجو و فیلتر زمانی پیاده‌سازی شده است.

### فناوری‌ها
- Java 21
- Spring Boot 3
- Spring MVC / Thymeleaf
- Spring Data JPA
- MySQL
- H2 (development)
- Bootstrap RTL
- Maven

### قابلیت‌های فعلی
- ثبت Temperature، pH، DO و EC
- ثبت محل، زمان و توضیحات نمونه
- داشبورد آخرین اندازه‌گیری‌ها
- صفحه کامل سوابق
- جستجو بر اساس محل
- فیلتر بر اساس بازه زمانی
- حذف رکورد با تأیید کاربر

### اجرا
```bash
mvn spring-boot:run -Dspring-boot.run.profiles=dev
```

سپس `http://localhost:8080` را باز کنید.

## Roadmap
- [x] 20% — Core setup + measurement registration + initial dashboard
- [x] 40% — History, search and filters
- [ ] 60% — Charts and analysis
- [ ] 80% — Thresholds, alerts and Excel export
- [ ] 100% — Testing, documentation and delivery

گزارش‌ها: [20%](PROGRESS_20.md) · [40%](PROGRESS_40.md)
