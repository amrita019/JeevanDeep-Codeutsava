# Generated by Django 2.1.4 on 2018-12-22 07:22

from django.db import migrations, models
import django.db.models.deletion


class Migration(migrations.Migration):

    dependencies = [
        ('authAPI', '0001_initial'),
    ]

    operations = [
        migrations.CreateModel(
            name='Verification',
            fields=[
                ('id', models.AutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('otp', models.CharField(default=0, help_text='The unique OTP of user', max_length=4)),
                ('numberOfTries', models.CharField(default=0, help_text='The number of times the user has requested the OTP', max_length=1)),
                ('user', models.ForeignKey(default=0, on_delete=django.db.models.deletion.CASCADE, to='authAPI.User')),
            ],
        ),
    ]
