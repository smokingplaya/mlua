# for windows (idk if it will be works on other platforms)

server_folder = "C:/Users/johngetman/Desktop/minecraft"
mlua_folder = "D:/MLua"

import subprocess
import os
import shutil

try:
    subprocess.run(['gradle', 'shadowJar'], check=True, shell=True)
    print("success")
except subprocess.CalledProcessError as e:
    print(f"error: {e}")

cmd_processes = subprocess.run(['tasklist', '/fi', 'imagename eq cmd.exe'], stdout=subprocess.PIPE, text=True)
if 'cmd.exe' in cmd_processes.stdout:
    subprocess.run(['taskkill', '/f', '/im', 'cmd.exe'])

file_name = "MLua-1.3-all.jar"

file_to_check = server_folder + "/plugins/" + file_name
if os.path.exists(file_to_check):
    os.remove(file_to_check)

source_file = mlua_folder + "/build/libs/" + file_name
destination_file = file_to_check
shutil.copy(source_file, destination_file)

bat_file_path = server_folder + "/start.bat"
subprocess.run(bat_file_path, cwd=server_folder, shell=True)