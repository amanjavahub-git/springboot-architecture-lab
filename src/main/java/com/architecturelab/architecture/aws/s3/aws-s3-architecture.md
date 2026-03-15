
---

## 📂 S3 Bucket Structure

The bucket `skybridge-employee` stores content in the following prefixes:

- `/files/` → Generic files
- `/json/` → JSON objects
- `/videos/` → Video files
- `/images/` → Image files

---

## 🔌 Swagger Endpoints

| Endpoint         | Method | Content-Type           | Description                     |
|------------------|--------|------------------------|---------------------------------|
| `/uploadFile`    | POST   | `multipart/form-data`  | Upload generic files            |
| `/uploadJson`    | POST   | `application/json`     | Upload structured JSON objects  |
| `/uploadVideo`   | POST   | `video/mp4`            | Upload video files              |
| `/uploadImage`   | POST   | `image/png`, `image/jpeg` | Upload image files           |

---

## 🔐 Security Considerations

- **Credential Management**: Never hardcode AWS credentials. Use environment variables or IAM roles.
- **Bucket Policies**: Apply least privilege access policies to control who can read/write.
- **Data Validation**: Validate file types and sizes before upload.
- **Logging**: Enable S3 access logs for auditing.
- **Encryption**: Use server-side encryption (SSE-S3 or SSE-KMS) for sensitive data.

---

## 🛠️ Best Practices

- Use **presigned URLs** for secure client-side uploads.
- Implement **retry logic** for failed uploads.
- Monitor bucket usage with **CloudWatch metrics**.
- Use **versioning** to track file changes.
- Apply **lifecycle policies** to manage storage costs.

---

## 📑 Swagger Integration Tips

- Define schemas for each upload type in `components/schemas`.
- Use `multipart/form-data` for file uploads.
- Include example payloads for better documentation.
- Enable CORS if Swagger is hosted separately.
- Secure endpoints with API keys or OAuth2.

---

## ✅ Summary

This architecture provides a robust, scalable, and secure solution for storing diverse content types in AWS S3 using the `skybridge-employee` bucket. With Swagger-powered endpoints and AWS SDK integration, it ensures seamless developer experience and operational efficiency.

