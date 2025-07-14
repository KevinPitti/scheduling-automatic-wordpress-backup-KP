FECHA=$(date +%F_%H-%M)
SITE="/var/www/html/wordpress"
BACKUP_LOCAL="/home/kali/Desktop/wordpress"
BACKUP_EXTERNO="/home/kali/Desktop/f"
BACKUP_DISK2="/home/kali/Desktop/Disk2"
DB="wordpress_db"
DB_USER="wordpress_user"
DB_PASS="wordpressSuperSecurePassword"


mkdir -p "$BACKUP_LOCAL"
mkdir -p "$BACKUP_EXTERNO"
mkdir -p "$BACKUP_DISK2"


ARCHIVOS="$BACKUP_LOCAL/archivos_$FECHA"
BASE="$BACKUP_LOCAL/db_$FECHA.sql"
TAR="$BACKUP_LOCAL/wordpress_$FECHA.tar.gz"


cp -a "$SITE" "$ARCHIVOS"


mysqldump -u "$DB_USER" -p"$DB_PASS" "$DB" > "$BASE"


tar -czf "$TAR" "$ARCHIVOS" "$BASE"


cp "$TAR" "$BACKUP_EXTERNO/"
cp "$TAR" "$BACKUP_DISK2/"


rm -rf "$ARCHIVOS" "$BASE"

echo "Backup completado: $TAR"
